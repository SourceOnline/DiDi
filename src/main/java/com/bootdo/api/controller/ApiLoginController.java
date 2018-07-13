package com.bootdo.api.controller;

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
import com.bootdo.api.entity.UserInfoEntity;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.ApitokenDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.ApitokenService;
import com.bootdo.system.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiLoginController extends ApiBaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private ApitokenService apitokenService;

	@Log("app登陆")
	@GetMapping("/login")
	public JsonModel login(String username, String password) {
		String flag = ApiCheckNull.login(username, password);
		if (null != flag) {
			return failure(flag);
		}
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			long uid = ShiroUtils.getUser().getUserId();
			String tokenId = apitokenService.saveLogin(uid,null);
			return successMap("登陆成功", "token", tokenId);
		} catch (AuthenticationException e) {
			return failure("用户或密码错误");
		}
	}

	@Log("app注册用户")
	@GetMapping("/register")
	public JsonModel register(UserDO user) {
		String flag = ApiCheckNull.register(user);
		if (null != flag) {
			return failure(flag);
		}
		// 根据用户名判断用户是否存在
		Map<String, Object> findUser = new HashMap<String, Object>();
		findUser.put("username", user.getUsername());
		if (userService.exit(findUser)) {
			return failure("用户已存在");
		}
		// 防止其他参数误填
		UserDO bean = new UserDO();
		bean.setName(user.getName());
		bean.setUsername(user.getUsername());
		bean.setPassword(user.getPassword());
		// 用户身份
		List<Long> roleIds = new ArrayList<Long>();
		roleIds.add(3L);// 新用户都是学员身份
		bean.setRoleIds(roleIds);

		bean.setDeptId((long) 1);// 默认部门id
		bean.setStatus(1);// 使用状态,1表示正常
		bean.setGmtCreate(new Date());// 创建时间
		if (userService.save(bean) > 0) {
			return success("添加成功！");
		}
		return failure("添加失败！");
	}

	@Log("wechat登陆")
	@GetMapping("/loginByOpenId")
	public JsonModel loginByOpenId(String openId) {
		String flag = ApiCheckNull.loginByOpenId(openId);
		if (null != flag) {
			return failure(flag);
		}
		ApitokenDO apitoken = apitokenService.findByOpenId(openId);
		if (null != apitoken && apitoken.getStatus().equals(1)) {
			UserDO user = userService.get(apitoken.getUserId());
			if (null != user) {
				//shiro登陆
				UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
				Subject subject = SecurityUtils.getSubject();
				try {
					subject.login(token);
					long uid = ShiroUtils.getUser().getUserId();
					String tokenId = apitokenService.saveLogin(uid,openId);
					
					//整理user信息
					UserInfoEntity entity = new UserInfoEntity(user);
					//性别
					DictDO dirt = dictService.get(user.getSex());
					if(null!=dirt){
						entity.setSex(dirt.getName());
					}
					entity.setTeacher(userService.checkIfTeacher(user.getUserId()));
					//用户头像
					FileDO fileDO = fileService.get(user.getPicId());
					if(null!=fileDO){
						entity.setAvatar(fileDO.getUrl());
					}else{
						entity.setAvatar("");
					}
					entity.setToken(tokenId);
					return successMap("user", entity);
					//return successMap("登陆成功", "token", tokenId);
				} catch (AuthenticationException e) {
					return failure("登陆失败");
				}
			}
		}
		return failure("用户未注册");
	}

	@Log("wechat注册")
	@GetMapping("weRegister")
	public JsonModel weRegister(String openId, String username, String phone, String sex) {
		String flag = ApiCheckNull.weRegister(openId, username, phone, sex);
		if (null != flag) {
			return failure(flag);
		}
		ApitokenDO apitoken = apitokenService.findByOpenId(openId);
		if (null != apitoken && apitoken.getStatus().equals(1)) {
			return failure("用户已注册");
		}
		// 根据用户名判断用户是否存在
		Map<String, Object> findUser = new HashMap<String, Object>();
		findUser.put("username", username);
		if (userService.exit(findUser)) {
			return failure("用户已存在");
		}
		//查询性别
		Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        param.put("name", sex);
        List<DictDO> dicts = dictService.list(param);
        if(null==dicts||dicts.size()<=0){
        	return failure("性别不存在");
        }
        //用户信息
		UserDO bean = new UserDO();
		bean.setName(username);
		bean.setUsername(username);
		bean.setPassword(MD5Utils.encrypt(username, "123456"));// 默认密码是123456
		bean.setMobile(phone);
		bean.setSex(dicts.get(0).getId());
		// 用户身份
		List<Long> roleIds = new ArrayList<Long>();
		roleIds.add(3L);// 新用户都是学员身份
		bean.setRoleIds(roleIds);

		bean.setDeptId((long) 1);// 默认部门id
		bean.setStatus(1);// 使用状态,1表示正常
		bean.setGmtCreate(new Date());// 创建时间
		if (userService.save(bean) <= 0) {
			return failure("注册失败！");
		}
		UserDO user = userService.get(findUser);
		if(null!=user){
			String tokenId = apitokenService.saveLogin(user.getUserId(),openId);
			//整理user信息
			UserInfoEntity entity = new UserInfoEntity(user);
			entity.setTeacher(false);
			entity.setSex(sex);
			entity.setToken(tokenId);
			return successMap("user", entity);
			//return successMap("登陆成功", "token", tokenId);
		}
		return failure("注册失败！");
	}

}
