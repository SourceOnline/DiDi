package com.bootdo.system.service;

import com.bootdo.system.domain.SubjectDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-06 10:14:38
 */
public interface SubjectService {
	
	SubjectDO get(String subjectId);
	
	List<SubjectDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubjectDO subject);
	
	int update(SubjectDO subject);
	
	int remove(String subjectId);
	
	int batchRemove(String[] subjectIds);
}
