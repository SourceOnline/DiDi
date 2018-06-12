package com.bootdo.system.dao;

import com.bootdo.system.domain.AddressDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-06 15:56:47
 */
@Mapper
public interface AddressDao {

	AddressDO get(Long addressId);
	
	List<AddressDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AddressDO address);
	
	int update(AddressDO address);
	
	int remove(Long address_id);
	
	int batchRemove(Long[] addressIds);
}
