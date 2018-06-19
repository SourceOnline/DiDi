package com.bootdo.api.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.api.commen.Constants;
import com.bootdo.api.commen.JsonModel;
import com.bootdo.api.entity.AddressEntity;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.system.domain.AddressDO;
import com.bootdo.system.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class ApiAddressController extends ApiBaseController{
	@Autowired
	private AddressService addressService;
	
	@Log("app获取收藏地址列表")
	@GetMapping("/getList")
	public JsonModel getList() {
		List<AddressEntity> backList = new ArrayList<AddressEntity>();
		Map<String, Object> map = new HashMap<>();
		map.put("userId", getUserId());
		List<AddressDO> list = addressService.list(map);
		if(null!=list&&list.size()>0){
			for(int i=0; i<list.size(); i++){
				AddressDO bean = list.get(i);
				AddressEntity entity = new AddressEntity(bean);
				if(null!=bean.getType()){
					if(bean.getType().equals(Constants.ADDRESS_TYPE_HOME)){
						entity.setType("家庭地点");
					}
					if(bean.getType().equals(Constants.ADDRESS_TYPE_WORK)){
						entity.setType("工作地点");
					}
				}else{
					entity.setType("");
				}
				backList.add(entity);
			}
		}
		return successMap("address", backList);
	}

	@Log("app教员设置工作位置")
	@GetMapping("/setHome")
	public JsonModel setHome(Float longitude, Float latitude,String token, String message) {
		String flag = ApiCheckNull.setHome(longitude, latitude, message);
		if(null!=flag){
			return failure(flag);
		}
		//检测家地址是否存在
		AddressDO find= addressService.getByUserId(getUserId(),Constants.ADDRESS_TYPE_WORK);
		
		if(null==find){
			AddressDO address = new AddressDO();
			address.setUserId(getUserId());
			address.setLongitude(longitude);
			address.setLatitude(latitude);
			address.setType(Constants.ADDRESS_TYPE_WORK);
			address.setAddtime(new Date());
			address.setMessage(message);
			address.setEnable(1);
			if(addressService.save(address)>0){
				return success("设置成功");
			}
		}else{
			find.setLongitude(longitude);
			find.setLatitude(latitude);
			find.setAddtime(new Date());
			find.setMessage(message);
			if(addressService.update(find)>0){
				return success("设置成功");
			}
		}
		return success("操作失败");
	}
}
