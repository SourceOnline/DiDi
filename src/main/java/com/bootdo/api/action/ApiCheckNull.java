package com.bootdo.api.action;

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
	
	public static String setHome(Float longitude, Float latitude){
		if(longitude<-180||longitude>180){
			return "经度不合法";
		}
		if(latitude<-90||latitude>90){
			return "维度不合法";
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
		if(od.getAddressX()<-180||od.getAddressX()>180){
			return "经度不合法";
		}
		if(od.getAddressY()<-90||od.getAddressY()>90){
			return "维度不合法";
		}
		if(StringUtils.isEmpty(od.getAddress())){
			return "详细地址不为空";
		}
		if(StringUtils.isEmpty(od.getSubjectId())){
			return "科目不为空";
		}
		if(0==od.getGrade()){
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
}
