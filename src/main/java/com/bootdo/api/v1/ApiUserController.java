package com.bootdo.api.v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.api.commen.JsonModel;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.ApitokenService;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.UserVO;

@RestController
@RequestMapping("/api/user")
public class ApiUserController extends ApiBaseController{

	@Autowired
	private UserService userService;
	@Autowired
	private ApitokenService apitokenService;
	
	
	
	@Log("获取用户")
	@GetMapping(value = "/getUser")
	public JsonModel getUser(Long id){
		UserDO userDO = getUser();
		return successMap("user", userDO);
	}
	
	@Log("app退出登陆")
	@GetMapping("/logout")
	public JsonModel logout(String token){
		apitokenService.tokenLogout(token);
		ShiroUtils.logout();
		return success("推出成功！");
	}
	
	@Log("修改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
	public JsonModel resetPwd(UserVO userVO) {
		try{
			userService.resetPwd(userVO,getUser());
			return success("操作成功");
		}catch (Exception e){
			return failure(e.getMessage());
		}

	}
}
