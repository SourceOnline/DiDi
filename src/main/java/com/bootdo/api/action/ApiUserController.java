package com.bootdo.api.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.api.commen.Constants;
import com.bootdo.api.commen.JsonModel;
import com.bootdo.api.entity.TeacherAroundEntity;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.IdUtils;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.AddressDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.AddressService;
import com.bootdo.system.service.ApitokenService;
import com.bootdo.system.service.UserService;
import com.bootdo.system.vo.UserVO;

@RestController
@RequestMapping("/api/user")
public class ApiUserController extends ApiBaseController{

	@Autowired
	private ApitokenService apitokenService;
	
	
	@Log("获取用户信息")
	@GetMapping(value = "/getUser")
	public JsonModel getUserMsg(){
		UserDO userDO = getUser();
		return successMap("user", userDO);
	}
	
	@Log("app退出登陆")
	@GetMapping("/logout")
	public JsonModel logout(String token){
		apitokenService.tokenLogout(token);
		ShiroUtils.logout();
		return success("退出登陆！");
	}
	
	@Log("app修改用户密码")
	@PostMapping("/resetPwd")
	public JsonModel resetPwd(UserVO userVO) {
		String flag = ApiCheckNull.resetPwd(userVO);
		if(null!=flag){
			return failure(flag);
		}
		userVO.setUserDO(getUser());
		try{
			userService.resetPwd(userVO,getUser());
			return success("操作成功");
		}catch (Exception e){
			return failure(e.getMessage());
		}
	}
	
	@Log("app普通用户成为教员")
	@GetMapping("/toTeacher")
	public JsonModel toTeacher() {
		userService.toTeacher(getUserId());
		return success("操作成功！");
	}
	
}
