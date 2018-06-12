package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.AddressDao;
import com.bootdo.system.domain.AddressDO;
import com.bootdo.system.service.AddressService;



@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public AddressDO get(Long addressId){
		return addressDao.get(addressId);
	}
	
	@Override
	public List<AddressDO> list(Map<String, Object> map){
		return addressDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return addressDao.count(map);
	}
	
	@Override
	public int save(AddressDO address){
		return addressDao.save(address);
	}
	
	@Override
	public int update(AddressDO address){
		return addressDao.update(address);
	}
	
	@Override
	public int remove(Long addressId){
		return addressDao.remove(addressId);
	}
	
	@Override
	public int batchRemove(Long[] addressIds){
		return addressDao.batchRemove(addressIds);
	}

	/** 
	 * 查询附近坐标 
	 * @param longitude 经度，范围为-180~180，负数表示西经 
	 * @param latitude  纬度，范围为-90~90，负数表示南纬 
	 * @param distance  搜索范围(单位:千米)   
	 * @param type 坐标类型（HOME,学生地址;WORK,教员地址）
	 * @return  搜索结果(坐标记录) 
	 */ 
	@Override
	public List<AddressDO> findNeighPosition(double longitude, double latitude, double distance,String type) {
		//先计算查询点的经纬度范围
        double r = 6371;//地球半径千米
        double dis = distance;//范围(单位:千米)
        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));
        dlng = dlng*180/Math.PI;//角度转为弧度
        double dlat = dis/r;
        dlat = dlat*180/Math.PI;        
        double minlat =latitude-dlat;//最小维度
        double maxlat = latitude+dlat;//最大维度
        double minlng = longitude -dlng;//最小经度
        double maxlng = longitude + dlng;//最大经度

        Map<String, Object> map = new HashMap<>();
		map.put("minlat", minlat);
		map.put("maxlat", maxlat);
		map.put("minlng", minlng);
		map.put("maxlng", maxlng);
		map.put("type", type);
		
		return list(map);
	}

	/**
	 * 根据userId和type(类型)查询家坐标记录
	 * */
	@Override
	public AddressDO getByUserId(long userId,String type) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("type", type);
		List<AddressDO> list = list(map);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
}
