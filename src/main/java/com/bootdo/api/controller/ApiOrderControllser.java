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

import com.alibaba.druid.util.StringUtils;
import com.bootdo.api.commen.Constants;
import com.bootdo.api.commen.JsonModel;
import com.bootdo.api.entity.OrderDetailEntity;
import com.bootdo.api.entity.TeacherAroundEntity;
import com.bootdo.api.util.PositionUtil;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.system.domain.AddressDO;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.AddressService;
import com.bootdo.system.service.OrderService;

/**
 * @author geyy
 * @date 2018年6月7日 上午11:19:34
 */
@RestController
@RequestMapping("/api/order")
public class ApiOrderControllser extends ApiBaseController{
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private FileService fileService;
	
	@Log("app查询周边教员")
	@GetMapping("/findTeacher")
	public JsonModel findTeacher(Float longitude, Float latitude,String token) {
		String flag = ApiCheckNull.findTeacher(longitude, latitude);
		if(null!=flag){
			return failure(flag);
		}
		//返回信息
		List<TeacherAroundEntity> teachers = new ArrayList<TeacherAroundEntity>();
		//查询附近教员坐标
		List<AddressDO> addressList = addressService.findNeighPosition(longitude, latitude, 10, Constants.ADDRESS_TYPE_WORK);
		if(null!=addressList&&addressList.size()>0){
			for(int i=0; i<addressList.size(); i++){
				AddressDO address = addressList.get(i);
				UserDO user = userService.get(address.getUserId());
				if(null!=user){
					//整理信息
					TeacherAroundEntity entity = new TeacherAroundEntity();
					entity.setUserId(user.getUserId());
					entity.setLongitude(address.getLongitude());
					entity.setLatitude(address.getLatitude());
					//用户头像
					FileDO fileDO = fileService.get(user.getPicId());
					if(null!=fileDO){
						entity.setAvatar(getUploadPath()+fileDO.getUrl());
					}else{
						entity.setAvatar("");
					}
					entity.setUserName(user.getName());
					entity.setMsg("该用户很懒，没有留下什么信息");
					entity.setPrice("未定");
					teachers.add(entity);
				}
			}
		}
		return successMap("teachers", teachers);
	}

	@Log("app发布家教任务")
	@GetMapping("/askForTeach")
	public JsonModel askForTeach(OrderDO order){
		String flag = ApiCheckNull.askForTeach(order);
		if(null!=flag){
			return failure(flag);
		}
		AddressDO addressDO = addressService.get(order.getAddressId());
		if(null==addressDO){
			return failure("地址有误");
		}
		if(null!=order.getTeacherUser()&&0==order.getTeacherUser()){
			order.setTeacherUser(null);
		}
		order.setAddressX(addressDO.getLongitude());
		order.setAddressY(addressDO.getLatitude());
		order.setAddress(addressDO.getAddressName()+" "+addressDO.getAddressDetail());
		order.setLearnUser(getUserId());
		order.setStatus(Constant.ORDER_STATUS_UNDO);//未处理状态
		order.setAddtime(new Date());
		order.setEnable(Constant.ENABLE_EXIST);
		orderService.save(order);
		//推送???
		if(null==order.getTeacherUser()){
			return success("预约成功");
		}
		return success("发布成功");
	}
	
	@Log("app任务详情")
	@GetMapping("/orderDetail")
	public JsonModel orderDetail(long orderId){
		String flag = ApiCheckNull.detail(orderId);
		if(null!=flag){
			return failure(flag);
		}
		OrderDO order = orderService.get(orderId);
		if(null==order){
			return failure("订单不存在");
		}
		OrderDetailEntity orderEntity = new OrderDetailEntity(order);
		UserDO learn = userService.get(order.getLearnUser());
		if(null!=learn){
			orderEntity.setLearnUserName(learn.getName());
			orderEntity.setLearnUserPhone(learn.getMobile());
		}
		UserDO teacher = userService.get(order.getTeacherUser());
		if(null!=teacher){
			orderEntity.setTecherName(teacher.getName());
			orderEntity.setTeacherPhone(teacher.getMobile());
		}
		
		return successMap("order", orderEntity);
	}
	
	@Log("app查询附近家教资源")
	@GetMapping("/findStudent")
	public JsonModel findStudent(Integer grade,String subjectId){
		//科目/年级/
		//时间,价格先不管
		//教员地点
		AddressDO addressDO = addressService.getByUserId(getUserId(), Constants.ADDRESS_TYPE_WORK);
		if(null==addressDO){
			return failure("工作地点还没设置");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("status", Constant.ORDER_STATUS_UNDO);
		map.put("enable", Constant.ENABLE_EXIST);
		if(null!=grade&&grade<=12&&grade>0){
			map.put("grade", grade);
		}
		if(!StringUtils.isEmpty(subjectId)){
			map.put("subjectId", subjectId);
		}
		map.putAll(PositionUtil.findNeighPosition(addressDO.getLongitude(), addressDO.getLatitude(), Constants.POSITION_DISTANCE));
		
		List<OrderDO> orderList = orderService.list(map);
		return successMap("orders", orderList);
	}
	
	@Log("app接取家教任务")
	@GetMapping("/acceptTask")
	public JsonModel acceptTask(long orderId){
		String flag = ApiCheckNull.acceptTask(orderId);
		if(null!=flag){
			return failure(flag);
		}
		//判断是否有其他单，时间是否冲突。暂不处理
//		Map<String, Object> map = new HashMap<>();
//		map.put("status", Constant.ORDER_STATUS_ON);
//		map.put("enable", Constant.ENABLE_EXIST);
//		List<OrderDO> list = orderService.list(map);
//		if(null!=list&&list.size()>0){
//			return failure("目前还有没完成的订单");
//		}
		OrderDO order = orderService.get(orderId);
		if(null!=order){
			//预约或未开始
			if(order.getStatus()==Constant.ORDER_STATUS_UNDO||order.getStatus()==Constant.ORDER_STATUS_ADVANCE){
				order.setTeacherUser(getUserId());
				order.setStatus(Constant.ORDER_STATUS_ON);
				orderService.update(order);
				//已读未读？？？
			}else{
				return failure("订单发生变化或已经被接取");
			}
		}
		return success("发布成功");
	}
	
	@Log("app完成订单")
	@GetMapping("/finishOrder")
	public JsonModel finishOrder(long orderId){
		String flag = ApiCheckNull.finishOrder(orderId);
		if(null!=flag){
			return failure(flag);
		}
		OrderDO order = orderService.get(orderId);
		if(null!=order){
			if(order.getLearnUser().equals(getUserId())){
				order.setStatus(Constant.ORDER_STATUS_FINISH);
				orderService.update(order);
				//支付相关？？
				//通知、推送？?
				//积分？？
				//
			}
		}
		return success("操作成功");
	}
	
	
	
}
