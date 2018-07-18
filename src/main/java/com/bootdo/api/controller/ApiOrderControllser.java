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
import com.bootdo.api.entity.FindStuSelectEntity;
import com.bootdo.api.entity.GradeAndNameEntity;
import com.bootdo.api.entity.OrderDetailEntity;
import com.bootdo.api.entity.SelectEntity;
import com.bootdo.api.entity.StudentAroundEntity;
import com.bootdo.api.entity.SubjectEntity;
import com.bootdo.api.entity.TeacherAroundEntity;
import com.bootdo.api.util.GradesUtil;
import com.bootdo.api.util.PositionUtil;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.system.domain.AddressDO;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.domain.SubjectDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.AddressService;
import com.bootdo.system.service.OrderService;
import com.bootdo.system.service.SubjectService;

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
	private SubjectService subjectService;
	
	@Log("app查询周边教员")
	@GetMapping("/findTeacher")
	public JsonModel findTeacher(Float longitude, Float latitude,String token) {
		String flag = ApiCheckNull.findTeacher(longitude, latitude);
		if(null!=flag){
			return failure(flag);
		}
		System.out.println(longitude);
		System.out.println(latitude);
		//返回信息
		List<TeacherAroundEntity> teachers = new ArrayList<TeacherAroundEntity>();
		//查询附近教员坐标
		List<AddressDO> addressList = addressService.findNeighPosition(longitude, latitude, 10);
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
						entity.setAvatar(fileDO.getUrl());
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
		order.setStatus(Constant.ORDER_STATUS_UNDO);//未处理状态
		System.out.println("getTeacherUser : "+order.getTeacherUser());
		//判断是否预约
		if(null!=order.getTeacherUser()&&0==order.getTeacherUser()){
			order.setTeacherUser(null);
			order.setType(Constant.ORDER_TYPE_UNRESERVE);//非预约的
			//order.setStatus(Constant.ORDER_STATUS_ADVANCE);//预约状态
		}else{
			order.setType(Constant.ORDER_TYPE_RESERVE);//预约
		}
		order.setAddressX(addressDO.getLongitude());
		order.setAddressY(addressDO.getLatitude());
		order.setAddress(addressDO.getAddressName()+" "+addressDO.getAddressDetail());
		order.setLearnUser(getUserId());
		
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
		orderEntity.setSubjectName(order.getSubject());
		if(null==orderEntity.getMessage()){
			orderEntity.setMessage("");
		}
		
		return successMap("order", orderEntity);
	}
	
	@Log("app查询附近家教资源")
	@GetMapping("/findStudent")
	public JsonModel findStudent(Float longitude, Float latitude,Integer grade,String subjectId,String order,int page){
		//科目/年级/
		//时间,价格先不管
		//教员地点
		//排序-智能排序-口碑排序order
		AddressDO addressDO = addressService.getByUserId(getUserId(), Constants.ADDRESS_TYPE_WORK);
		if(null==addressDO){
			return failure("工作地点还没设置");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("status", Constant.ORDER_STATUS_UNDO+"");
		map.put("enable", Constant.ENABLE_EXIST);
		if(null!=grade&&grade<=12&&grade>0){
			map.put("grade", grade);
		}
		if(!StringUtils.isEmpty(subjectId)&&!subjectId.equals("0")){
			map.put("subjectId", subjectId);
		}
		//设置查询范围
//		double d_lon = 114.38273;
//		double d_lat = 23.08383;
//		if(!StringUtils.isEmpty(addressDO.getLongitude())&&!StringUtils.isEmpty(addressDO.getLatitude())){
//			d_lon = Double.parseDouble(addressDO.getLongitude());
//			d_lat = Double.parseDouble(addressDO.getLatitude());
//		}
		map.putAll(PositionUtil.findNeighPosition(longitude, latitude, Constants.POSITION_DISTANCE));
		
		List<OrderDO> orderList = orderService.pageList(map, page, Constant.PAGE_SIZE);
		
		List<StudentAroundEntity> backList = new ArrayList<>();
		if(null!=orderList&&orderList.size()>0){
			for(int i=0; i<orderList.size(); i++){
				OrderDO bean = orderList.get(i);
				UserDO user = userService.get(bean.getLearnUser());
				if(null!=user){
					System.out.println(user.toString());
					StudentAroundEntity entity = new StudentAroundEntity(bean);
					//用户头像
					FileDO fileDO = fileService.get(user.getPicId());
					if(null!=fileDO){
						entity.setAvatar(fileDO.getUrl());
					}else{
						entity.setAvatar("");
					}
					backList.add(entity);
				}
			}
		}
		int total = orderService.count(map);
		PageUtils pageUtil = new PageUtils(backList, total);
		
		return success(pageUtil);
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
			if(order.getStatus()==Constant.ORDER_STATUS_UNDO){
				order.setTeacherUser(getUserId());
				order.setStatus(Constant.ORDER_STATUS_ON);
				orderService.update(order);
				//已读未读？？？
			}else{
				return failure("订单发生变化或已经被接取");
			}
		}
		return success("接单成功");
	}
	
	@Log("app查询我的订单(家长)")
	@GetMapping("/myOrders")
	public JsonModel myOrders(Integer status, Integer page){
		String flag = ApiCheckNull.myOrders(status);
		if(null!=flag){
			return failure(flag);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("learnUser", getUserId());
		map.put("status", status+"");
		map.put("enable", Constant.ENABLE_EXIST);
		
		List<OrderDO> orderList = orderService.pageList(map, page, Constant.PAGE_SIZE);
		
		int total = orderService.count(map);
		PageUtils pageUtil = new PageUtils(orderList, total);
		
		//orderService.pageList(map, null, 0);
		
		return success(pageUtil);
	}
	
	@Log("app查询我的任务(教员)")
	@GetMapping("/myTasks")
	public JsonModel myTasks(Integer status, Integer page){
		String flag = ApiCheckNull.myTasks(status);
		if(null!=flag){
			return failure(flag);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("teacherUser", getUserId());
		map.put("status", status+"");
		map.put("type", Constant.ORDER_TYPE_UNRESERVE);//非预约
		map.put("enable", Constant.ENABLE_EXIST);
		
		if(status==5){
			map.put("status", 0+"");
			map.put("type", Constant.ORDER_TYPE_RESERVE);//非预约
		}
		
		List<OrderDO> orderList = orderService.pageList(map, page, Constant.PAGE_SIZE);
		
		int total = orderService.count(map);
		PageUtils pageUtil = new PageUtils(orderList, total);
		
		//orderService.pageList(map, null, 0);
		
		return success(pageUtil);
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
				order.setStatus(Constant.ORDER_STATUS_FINISH);//完成
				orderService.update(order);
				//支付相关？？
				//通知、推送？?
				//积分？？
				//
			}
		}
		return success("操作成功");
	}
	
	@Log("app撤销订单")
	@GetMapping("/cancleOrder")
	public JsonModel cancleOrder(long orderId){
		String flag = ApiCheckNull.cancleOrder(orderId);
		if(null!=flag){
			return failure(flag);
		}
		OrderDO order = orderService.get(orderId);
		if(null!=order){
			//接单和完成时不能撤销
			if(order.getStatus()==Constant.ORDER_STATUS_ON||order.getStatus()==Constant.ORDER_STATUS_FINISH){
				return failure("不能撤销");
			}
			
			if(order.getLearnUser().equals(getUserId())){
				order.setStatus(Constant.ORDER_STATUS_CANCLE);//撤销
				orderService.update(order);
			}
		}
		return success("操作成功");
	}
	
	@Log("app查询学生选择器")
	@GetMapping("/findStuSelect")
	public JsonModel findStuSelect(String style){
		FindStuSelectEntity backEntity = new FindStuSelectEntity();
		backEntity.setSubject_list(getSubject());
		backEntity.setGrade_list(getGrade());
		backEntity.setOrder_list(getOrder());
		return successMap("select", backEntity);
	}
	
	/**
	 * 科目选择
	 * */
	public List<SelectEntity> getSubject(){
		List<SelectEntity> backList = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("type", 1);
		map.put("enable", 1);
		List<SubjectDO> list = subjectService.list(map);
		if(null!=list&&list.size()>0){
			for(int i=0; i<list.size(); i++){
				SelectEntity entity = new SelectEntity();
				SubjectDO bean = list.get(i);
				entity.setId(bean.getSubjectId());
				entity.setName(bean.getName());
				entity.setCode(bean.getCode());
				entity.setSort(bean.getSort());
				backList.add(entity);
			}
		}
		return backList;
	}
	
	/**
	 * 年级选择
	 * */
	public List<SelectEntity> getGrade(){
		List<SelectEntity> backList = new ArrayList<>();
		for(int i=1; i<=12; i++){
			SelectEntity entity = new SelectEntity();
			entity.setId(i+"");
			entity.setName(GradesUtil.getGradeBynum(i));
			entity.setCode(i+"");
			entity.setSort(i);
			backList.add(entity);
		}
		return backList;
	}
	
	/**
	 * 排序选择
	 * */
	public List<SelectEntity> getOrder(){
		List<SelectEntity> backList = new ArrayList<>();
		SelectEntity entity = new SelectEntity();
		entity.setId("1");
		entity.setName("智能排序");
		entity.setCode("1");
		entity.setSort(1);
		backList.add(entity);
		
		entity = new SelectEntity();
		entity.setId("2");
		entity.setName("口碑排序");
		entity.setCode("2");
		entity.setSort(2);
		backList.add(entity);
		
		return backList;
	}
	
	
	
}
