package com.bootdo.system.service;

import com.bootdo.system.domain.AddressDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-06 15:56:47
 */
public interface AddressService {
	
	AddressDO get(Long addressId);
	
	List<AddressDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AddressDO address);
	
	int update(AddressDO address);
	
	int remove(Long addressId);
	
	int batchRemove(Long[] addressIds);
	
	/**
	 * 根据userId和type(类型)查询家坐标记录
	 * */
	public AddressDO getByUserId(long userId,String type);
	
	/** 
	 * 查询附近坐标 
	 * @param longitude 经度，范围为-180~180，负数表示西经 
	 * @param latitude  纬度，范围为-90~90，负数表示南纬 
	 * @param distance  搜索范围(单位:千米)   
	 * @param type 坐标类型（HOME,学生地址;WORK,教员地址）
	 * @return  搜索结果(坐标记录) 
	 */ 
	List<AddressDO> findNeighPosition(double longitude,  
	        double latitude, double distance,String type);
}
