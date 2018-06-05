package com.bootdo.api.v1;

import com.alibaba.druid.util.StringUtils;
import com.bootdo.system.domain.UserDO;

public class ApiCheckNull {

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
}
