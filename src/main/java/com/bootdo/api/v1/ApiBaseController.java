package com.bootdo.api.v1;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.cache.ContextCacheUtils;

import com.bootdo.api.commen.ApiSupport;
import com.bootdo.common.utils.HttpContextUtils;
import com.bootdo.system.domain.UserDO;

@Controller
public class ApiBaseController extends ApiSupport{

	public static UserDO getUser() {
		UserDO user = (UserDO) HttpContextUtils.getHttpServletRequest().getAttribute("user");
		return user;
	}

	public static Long getUserId() {
		return getUser().getUserId();
	}
}