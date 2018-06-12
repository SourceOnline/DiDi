package com.bootdo.api.action;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.api.commen.JsonModel;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.ApitokenService;
import com.bootdo.system.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiLoginController extends ApiBaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private ApitokenService apitokenService;
	
	@Log("app登陆")
	@GetMapping("/login")
	public JsonModel login(String username, String password){
		String flag = ApiCheckNull.login(username, password);
		if(null!=flag){
			return failure(flag);
		}
		password = MD5Utils.encrypt(username,password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			long uid = ShiroUtils.getUser().getUserId();
			String tokenId = apitokenService.saveLogin(uid);
			return successMap("登陆成功","token", tokenId);
		} catch (AuthenticationException e) {
			return failure("用户或密码错误");
		}
		
	}
	
	@Log("app注册用户")
	@GetMapping("/register")
	public JsonModel register(UserDO user){
		String flag = ApiCheckNull.register(user);
		if(null!=flag){
			return failure(flag);
		}
		//根据用户名判断用户是否存在
		Map<String, Object> findUser = new HashMap<String, Object>();
		findUser.put("username", user.getUsername());
		if(userService.exit(findUser)){
			return failure("用户已存在");
		}
		//防止其他参数误填
		UserDO bean = new UserDO();
		bean.setName(user.getName());
		bean.setUsername(user.getUsername());
		bean.setPassword(user.getPassword());
		//用户身份
		List<Long> roleIds = new ArrayList<Long>();
		roleIds.add(3L);//新用户都是学员身份
		bean.setRoleIds(roleIds);
		
		bean.setDeptId((long) 1);//默认部门id
		bean.setStatus(1);//使用状态,1表示正常
		bean.setGmtCreate(new Date());//创建时间
		if (userService.save(bean) > 0) {
			return success("添加成功！");
		}
		return failure("添加失败！");
	}
}
