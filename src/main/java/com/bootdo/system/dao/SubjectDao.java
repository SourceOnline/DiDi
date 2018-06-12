package com.bootdo.system.dao;

import com.bootdo.system.domain.SubjectDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-06 10:14:38
 */
@Mapper
public interface SubjectDao {

	SubjectDO get(String subjectId);
	
	List<SubjectDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SubjectDO subject);
	
	int update(SubjectDO subject);
	
	int remove(String subject_id);
	
	int batchRemove(String[] subjectIds);
}
