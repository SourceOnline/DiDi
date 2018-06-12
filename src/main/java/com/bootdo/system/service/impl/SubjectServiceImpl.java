package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.SubjectDao;
import com.bootdo.system.domain.SubjectDO;
import com.bootdo.system.service.SubjectService;



@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public SubjectDO get(String subjectId){
		return subjectDao.get(subjectId);
	}
	
	@Override
	public List<SubjectDO> list(Map<String, Object> map){
		return subjectDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return subjectDao.count(map);
	}
	
	@Override
	public int save(SubjectDO subject){
		return subjectDao.save(subject);
	}
	
	@Override
	public int update(SubjectDO subject){
		return subjectDao.update(subject);
	}
	
	@Override
	public int remove(String subjectId){
		return subjectDao.remove(subjectId);
	}
	
	@Override
	public int batchRemove(String[] subjectIds){
		return subjectDao.batchRemove(subjectIds);
	}
	
}
