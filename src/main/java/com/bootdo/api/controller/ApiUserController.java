package com.bootdo.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bootdo.api.commen.JsonModel;
import com.bootdo.api.entity.UserInfoEntity;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.ApitokenService;
import com.bootdo.system.vo.UserVO;

@RestController
@RequestMapping("/api/user")
public class ApiUserController extends ApiBaseController{

	@Autowired
	private ApitokenService apitokenService;
	
	
	@Log("app获取用户信息")
	@GetMapping(value = "/getUser")
	public JsonModel getUserMsg(){
		UserDO user = getUser();
		UserInfoEntity entity = new UserInfoEntity(user);
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
		return successMap("user", entity);
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
	
//	@Log("上传头像")
//	@PostMapping("/uploadImg")
//	public void uploadImg(HttpServletRequest request, HttpServletResponse response){
//        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
//        MultipartFile multipartFile =  req.getFile("file");
//        
//        Map<String, Object> result = new HashMap<>();
//        try {
//			result = userService.weChatUpdatePersonalImg(multipartFile, getUserId());
//			System.out.println(result.toString());
//			
//			PrintWriter printWriter = response.getWriter();
//	        response.setContentType("application/json");
//	        response.setCharacterEncoding("utf-8");
//	        HashMap<String, Object> res = new HashMap<String, Object>();
//	        res.put("status", 1);
//	        if(result!=null && result.size()>0){
//	        	res.put("data", result);
//	        	res.put("status", 1);
//	        }else{
//	        	res.put("status", 1);
//	        	res.put("message", "更新头像失败");
//	        }
//	        printWriter.write(JSON.toJSONString(res));
//	        printWriter.flush();
//		
//        } catch (Exception e) {
//			//return failure("更新图像失败！");
//		}
//    }
	
	@Log("上传头像")
	@PostMapping("/uploadImg")
	public JsonModel uploadImg(HttpServletRequest request){
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        
        Map<String, Object> result = new HashMap<>();
        try {
			result = userService.weChatUpdatePersonalImg(multipartFile, getUserId());
			System.out.println(result.toString());
		} catch (Exception e) {
			return failure("更新图像失败！");
		}
        
		if(result!=null && result.size()>0){
			return success(result);
		}else {
			return failure("更新图像失败！");
		}
	}
	
}
