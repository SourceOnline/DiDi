package com.bootdo.api.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.api.commen.JsonModel;
import com.bootdo.api.entity.TeacherDetailEntity;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.system.domain.UserDO;

@RestController
@RequestMapping("/api/teacher")
public class ApiTeacherController extends ApiAddressController{
	
	@Autowired
	private FileService fileService;

	@Log("api获取教师信息")
	@GetMapping("/teacherDetail")
	public JsonModel teacherDetail(long userId){
		String flag = ApiCheckNull.teacherDetail(userId);
		if(null!=flag){
			return failure(flag);
		}
		UserDO user = userService.get(userId);
		if(null==user){
			return failure("该用户不存在");
		}
		TeacherDetailEntity backEntity = new TeacherDetailEntity();
		backEntity.setUserId(user.getUserId());
		backEntity.setPrice("价格未定");
		backEntity.setUserName(user.getName());
		//用户头像
		FileDO fileDO = fileService.get(user.getPicId());
		if(null!=fileDO){
		}else{
			backEntity.setAvatar("");
		}
		System.out.println(getPath());
		
		return successMap("teacher", backEntity);
	}
	
}
