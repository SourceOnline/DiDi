package com.bootdo.system.dao;

import com.bootdo.system.domain.ApitokenDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-04 09:44:59
 */
@Mapper
public interface ApitokenDao {

	ApitokenDO get(String tokenid);
	
	List<ApitokenDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ApitokenDO apitoken);
	
	int update(ApitokenDO apitoken);
	
	int remove(String tokenId);
	
	int batchRemove(String[] tokenids);
}
