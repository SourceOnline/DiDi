package com.bootdo.api.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bootdo.api.commen.ApiSupport;
import com.bootdo.common.utils.HttpContextUtils;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.UserService;

@Controller
public class ApiBaseController extends ApiSupport{
	
	@Autowired
	protected UserService userService;

	public static UserDO getUser() {
		UserDO user = (UserDO) HttpContextUtils.getHttpServletRequest().getAttribute("user");
		String test = (String) HttpContextUtils.getHttpServletRequest().getAttribute("test");
		System.out.println("test getAttribute : "+test);
		return user;
	}

	public static Long getUserId() {
		return getUser().getUserId();
	}
	
	public static Boolean isTeacher(){
		return getUser().isTeacher();
	}
}