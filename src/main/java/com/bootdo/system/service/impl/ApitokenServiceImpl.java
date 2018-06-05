package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.bootdo.common.utils.IdUtils;
import com.bootdo.system.dao.ApitokenDao;
import com.bootdo.system.domain.ApitokenDO;
import com.bootdo.system.service.ApitokenService;



@Service
public class ApitokenServiceImpl implements ApitokenService {
	@Autowired
	private ApitokenDao apitokenDao;
	
	@Override
	public ApitokenDO get(String tokenid){
		return apitokenDao.get(tokenid);
	}
	
	@Override
	public List<ApitokenDO> list(Map<String, Object> map){
		return apitokenDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return apitokenDao.count(map);
	}
	
	@Override
	public int save(ApitokenDO apitoken){
		return apitokenDao.save(apitoken);
	}
	
	@Override
	public int update(ApitokenDO apitoken){
		return apitokenDao.update(apitoken);
	}
	
	@Override
	public int remove(String tokenid){
		return apitokenDao.remove(tokenid);
	}
	
	@Override
	public int batchRemove(String[] tokenids){
		return apitokenDao.batchRemove(tokenids);
	}
	
	@Override
	public ApitokenDO findByUserId(long userId){
		if(userId==0){
			return null;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("status", 1);
		List<ApitokenDO> list = list(map);
		if(null!=list&&list.size()>0){
			return (ApitokenDO) list.get(0);
		}
		return null;
	}

	@Override
	public String saveLogin(long userId) {
		ApitokenDO apitoken = (ApitokenDO) findByUserId(userId);
		if(null!=apitoken){
			apitoken.setLogintime(new Date());
			update(apitoken);
		}else{
			apitoken = new ApitokenDO();
			apitoken.setTokenid(IdUtils.getId());
			apitoken.setUserid(userId);
			apitoken.setLogintime(new Date());
			apitoken.setStatus(1);
			save(apitoken);
		}
		return apitoken.getTokenid();
	}

	@Override
	public String tokenLogout(String token) {
		ApitokenDO apitoken = get(token);
		if(null!=apitoken){
			apitoken.setStatus(0);
			update(apitoken);
		}
		return null;
	}

}
