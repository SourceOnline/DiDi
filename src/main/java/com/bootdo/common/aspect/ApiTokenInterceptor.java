package com.bootdo.common.aspect;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.ApitokenDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.ApitokenService;
import com.bootdo.system.service.UserService;

/**
 * api-登陆验证拦截
 */
@Component
public class ApiTokenInterceptor implements HandlerInterceptor {

	@Autowired
	private ApitokenService apitokenService;
	@Autowired
	private UserService userService;

	// 在业务处理器处理请求之前被调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", new Date().getTime());
		StringBuffer temp = request.getRequestURL();
		String path = temp.toString();
System.out.println("path : "+path);
		String tokenid = request.getParameter("token");
System.out.println("token : " + tokenid);
		if (null != tokenid) {
			ApitokenDO apitoken = apitokenService.get(tokenid);
			if (null != apitoken && apitoken.getStatus().equals(1)) {
				UserDO user = userService.get(apitoken.getUserId());
				if (null != user) {
					System.out.println(user.toString());
					user.setTeacher(userService.checkIfTeacher(user.getUserId()));
					request.setAttribute("user", user);
System.out.println("api 登陆拦截通过~");
					// 判断是否需要重新登陆
					userService.checkIfLogin(user.getUserId());
					return true;
				}
			}
		}

		return false;
	}

	// 在业务处理器处理请求完成之后，生成视图之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:" + (new Date().getTime() - start));

	}

	// 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:" + (new Date().getTime() - start));
		System.out.println("ex is " + ex);

	}

}
