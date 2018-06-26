package com.bootdo.api.controller;

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
import com.bootdo.api.util.PhoneUtil;
import com.bootdo.common.annotation.Log;
import com.bootdo.system.domain.AddressDO;
import com.bootdo.system.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class ApiAddressController extends ApiBaseController{
	@Autowired
	private AddressService addressService;
	
	@Log("获取地址详情")
	@GetMapping("/getDetail")
	public JsonModel getDetail(long addressId){
		String flag = ApiCheckNull.getDetail(addressId);
		if(null!=flag){
			return failure(flag);
		}
		AddressDO address = addressService.get(addressId);
		return successMap("address", address);
	}
	
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
				entity.setAddressNameAndDoor(bean.getAddressName()+" "+bean.getDoor());
				entity.setMessage(bean.getAddressDetail());
				entity.setNameAndhone(bean.getUserName()+ " "+PhoneUtil.middleHide(bean.getPhone()));
				backList.add(entity);
			}
		}
		return successMap("address", backList);
	}

	@Log("app教员设置工作位置")
	@GetMapping("/setHome")
	public JsonModel setHome(AddressDO address) {
		String flag = ApiCheckNull.setHome(address);
		if(null!=flag){
			return failure(flag);
		}
		//检测家地址是否存在
		//AddressDO find= addressService.getByUserId(getUserId(),Constants.ADDRESS_TYPE_WORK);
		
		if(null==address.getAddressId()||0==address.getAddressId()){
//			AddressDO address = new AddressDO();
			address.setUserId(getUserId());
			address.setType(Constants.ADDRESS_TYPE_WORK);
			address.setAddtime(new Date());
			address.setEnable(1);
			if(addressService.save(address)>0){
				return success("设置成功");
			}
		}else{
			address.setAddtime(new Date());
			if(addressService.update(address)>0){
				return success("设置成功");
			}
		}
		return success("操作失败");
	}
	
	@Log("删除地址")
	@GetMapping("/delete")
	public JsonModel elete(long addressId){
		String flag = ApiCheckNull.elete(addressId);
		if(null!=flag){
			return failure(flag);
		}
		if(addressService.remove(addressId)>0){
			return success("操作成功");
		}else{
			return failure("操作失败");
		}
	}
}
