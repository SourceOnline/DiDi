package com.bootdo.api.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bootdo.api.commen.ApiSupport;
import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.utils.HttpContextUtils;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.UserService;

@Controller
public class ApiBaseController extends ApiSupport{
	@Autowired
	BootdoConfig bootdoConfig;
	@Autowired
	protected UserService userService;

	public static UserDO getUser() {
		UserDO user = (UserDO) HttpContextUtils.getHttpServletRequest().getAttribute("user");
		return user;
	}

	public static Long getUserId() {
		return getUser().getUserId();
	}
	
	public static Boolean isTeacher(){
		return getUser().isTeacher();
	}
	
	/**
	 * 获取当前路径
	 * */
	public static String getPath(){
		String path = null;
//		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
//		StringBuffer temp = request.getRequestURL();
//		String path = temp.toString();
//		path = (String) path.subSequence(0, temp.indexOf("/api"));
		//api接口都是以/api开头的
		//String path = "http://localhost:8012";/
		return path;
	}
	
	/**
	 * 获取服务器文件上传路径
	 * */
	public String getUploadPath(){
		String str = bootdoConfig.getUploadPath();
		str = str.substring(0, str.length()-1);
		return str;
	}
	
}