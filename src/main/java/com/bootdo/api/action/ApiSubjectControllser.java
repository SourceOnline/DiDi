package com.bootdo.api.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.api.commen.JsonModel;
import com.bootdo.api.entity.GradeAndNameEntity;
import com.bootdo.api.entity.SubjectEntity;
import com.bootdo.api.util.GradesUtil;
import com.bootdo.common.annotation.Log;
import com.bootdo.system.domain.SubjectDO;
import com.bootdo.system.service.SubjectService;

/**
 * @author geyy
 * @date 2018年6月7日 上午11:19:34
 */
@RestController
@RequestMapping("/api/subject")
public class ApiSubjectControllser extends ApiBaseController{
	
	@Autowired
	private SubjectService subjectService;

	@Log("app查询科目列表")
	@GetMapping("/getSubects")
	public JsonModel getSubects(){
		List<SubjectEntity> listBack = new ArrayList<SubjectEntity>();
		Map<String, Object> map = new HashMap<>();
		map.put("type", 1);
		map.put("enable", 1);
		
		List<SubjectDO> list = subjectService.list(map);
		if(null!=list&&list.size()>0){
			for(int i=0; i<list.size(); i++){
				SubjectDO bean = list.get(i);
				SubjectEntity entity = new SubjectEntity(bean);
				listBack.add(entity);
			}
		}
		return successMap("查找成功！","subjects", listBack);
	}
	
	@Log("app查询年级列表")
	@GetMapping("/getGrades")
	public JsonModel getGrades(){
		List<GradeAndNameEntity> listBack = new ArrayList<GradeAndNameEntity>();
		for(int i=1; i<=12; i++){
			GradeAndNameEntity entity = new GradeAndNameEntity();
			entity.setGradeNum(i);
			entity.setGradeName(GradesUtil.getGradeBynum(i));
			listBack.add(entity);
		}
		return successMap("查找成功！","grades", listBack);
	}
	
}
