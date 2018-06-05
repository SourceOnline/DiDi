package com.bootdo.system.service;

import com.bootdo.system.dao.ApitokenDao;
import com.bootdo.system.domain.ApitokenDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-04 09:44:59
 */
public interface ApitokenService {
	
	ApitokenDO get(String tokenid);
	
	List<ApitokenDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ApitokenDO apitoken);
	
	int update(ApitokenDO apitoken);
	
	int remove(String tokenid);
	
	int batchRemove(String[] tokenids);

	/**
	 * app登陆，token保存
	 * */
	public String saveLogin(long userId);
	
	/**
	 * token设置离线（退出登陆）
	 * */
	public String tokenLogout(String token);

	/**
	 * 根据userId查询
	 * */
	public ApitokenDO findByUserId(long userId);
}
