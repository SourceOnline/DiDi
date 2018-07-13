package com.bootdo.api.controller;

import com.alibaba.druid.util.StringUtils;
import com.bootdo.system.domain.AddressDO;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.vo.UserVO;

public class ApiCheckNull {
	
	public static String login(String username, String password){
		if(StringUtils.isEmpty(username)){
			return "用户名不为空";
		}
		if(StringUtils.isEmpty(password)){
			return "密码不为空";
		}
		return null;
	}
	
	public static String loginByOpenId(String openId){
		if(StringUtils.isEmpty(openId)){
			return "openId不为空";
		}
		return null;
	}
	
	public static String weRegister(String openId,String username,String phone,String sex){
		if(StringUtils.isEmpty(openId)){
			return "openId不为空";
		}
		if(openId.equals("null")){
			return "openId不为null";
		}
		if(StringUtils.isEmpty(username)){
			return "用户名不为空";
		}
		if(StringUtils.isEmpty(phone)){
			return "手机号码不为空";
		}
		if(StringUtils.isEmpty(sex)){
			return "性别不为空";
		}
		if(!(sex.equals("男")||sex.equals("女"))){
			return "性别不合法";
		}
		return null;
	}

	public static String register(UserDO user){
		if(StringUtils.isEmpty(user.getUsername())){
			return "用户名不为空";
		}
		if(StringUtils.isEmpty(user.getName())){
			return "姓名不为空";
		}
		if(StringUtils.isEmpty(user.getPassword())){
			return "密码不为空";
		}
		return null;
	}
	
	public static String resetPwd(UserVO userVO){
		if(StringUtils.isEmpty(userVO.getPwdOld())){
			return "原密码不为空";
		}
		if(StringUtils.isEmpty(userVO.getPwdNew())){
			return "新密码不为空";
		}
		return null;
	}
	
	public static String setHome(AddressDO address){
		if(StringUtils.isEmpty(address.getLongitude())){
			return "经度不为空";
		}
		if(StringUtils.isEmpty(address.getLatitude())){
			return "维度不为空";
		}
//		int lon = Integer.parseInt(address.getLongitude().split(".")[0]);
//		int lat = Integer.parseInt(address.getLatitude().split(".")[0]);
//		if(lon<-180||lon>180){
//			return "经度不合法";
//		}
//		if(lat<-90||lat>90){
//			return "维度不合法";
//		}
		if(StringUtils.isEmpty(address.getAddressName())){
			return "地址名称不为空";
		}
		if(StringUtils.isEmpty(address.getAddressDetail())){
			return "详细地址不为空";
		}
		if(StringUtils.isEmpty(address.getDoor())){
			return "门号地址不为空";
		}
		return null;
	}
	
	public static String findTeacher(Float longitude, Float latitude){
		if(longitude<-180||longitude>180){
			return "经度不合法";
		}
		if(latitude<-90||latitude>90){
			return "维度不合法";
		}
		return null;
	}
	
	public static String askForTeach(OrderDO od){
//		if(od.getAddressX()<-180||od.getAddressX()>180){
//			return "经度不合法";
//		}
//		if(od.getAddressY()<-90||od.getAddressY()>90){
//			return "维度不合法";
//		}
		if(0==od.getAddressId()){
			return "地址不为空";
		}
		if(StringUtils.isEmpty(od.getSubject())){
			return "科目不为空";
		}
		if(StringUtils.isEmpty(od.getGrade())){
			return "年级不为空";
		}
		return null;
	}
	
	public static String detail(long orderId){
		if(0==orderId){
			return "orderId不为空";
		}
		return null;
	}
	
	public static String acceptTask(long orderId){
		if(0==orderId){
			return "orderId不为空";
		}
		return null;
	}
	
	public static String finishOrder(long orderId){
		if(0==orderId){
			return "orderId不为空";
		}
		return null;
	}
	
	public static String cancleOrder(long orderId){
		if(0==orderId){
			return "orderId不为空";
		}
		return null;
	}
	
	public static String teacherDetail(long userId){
		if(0==userId){
			return "userId不为空";
		}
		return null;
	}
	
	public static String getDetail(long addressId){
		if(0==addressId){
			return "地址id不为空";
		}
		return null;
	}
	
	public static String elete(long addressId){
		if(0==addressId){
			return "地址id不为空";
		}
		return null;
	}
	
	public static String myOrders(Integer status){
		if(null==status){
			return "状态不为空";
		}
		return null;
	}
	
	public static String myTasks(Integer status){
		if(null==status){
			return "状态不为空";
		}
		return null;
	}
	
	public static String updateUser(String username,String phone,String sex){
		if(StringUtils.isEmpty(username)){
			return "用户名不为空";
		}
		if(StringUtils.isEmpty(phone)){
			return "手机号码不为空";
		}
		if(StringUtils.isEmpty(sex)){
			return "性别不为空";
		}
		if(!(sex.equals("男")||sex.equals("女"))){
			return "性别不合法";
		}
		return null;
	}

}
