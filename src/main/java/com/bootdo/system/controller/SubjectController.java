package com.bootdo.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.SubjectDO;
import com.bootdo.system.service.SubjectService;
import com.alibaba.druid.util.StringUtils;
import com.bootdo.common.utils.IdUtils;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 科目管理
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-06 10:14:38
 */
 
@Controller
@RequestMapping("/system/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping()
	@RequiresPermissions("system:subject:subject")
	String Subject(){
	    return "system/subject/subject";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:subject:subject")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SubjectDO> subjectList = subjectService.list(query);
		int total = subjectService.count(query);
		PageUtils pageUtils = new PageUtils(subjectList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:subject:add")
	String add(){
	    return "system/subject/add";
	}

	@GetMapping("/edit/{subjectId}")
	@RequiresPermissions("system:subject:edit")
	String edit(@PathVariable("subjectId") String subjectId,Model model){
		SubjectDO subject = subjectService.get(subjectId);
		model.addAttribute("subject", subject);
	    return "system/subject/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:subject:add")
	public R save( SubjectDO subject){
		if(StringUtils.isEmpty(subject.getSubjectId())){
			subject.setSubjectId(IdUtils.getId());
		}
		subject.setAddtime(new Date());
		subject.setEnable(1);
		subject.setType(1);
		if(subjectService.save(subject)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:subject:edit")
	public R update( SubjectDO subject){
		subjectService.update(subject);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:subject:remove")
	public R remove( String subjectId){
		if(subjectService.remove(subjectId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:subject:batchRemove")
	public R remove(@RequestParam("ids[]") String[] subjectIds){
		subjectService.batchRemove(subjectIds);
		return R.ok();
	}
	
}
