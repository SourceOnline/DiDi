package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.common.config.Constant;
import com.bootdo.system.dao.OrderDao;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public OrderDO get(Long orderId){
		return orderDao.get(orderId);
	}
	
	@Override
	public OrderDO get(Map<String, Object> map){
		List<OrderDO> list = list(map);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public List<OrderDO> list(Map<String, Object> map){
		return orderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderDao.count(map);
	}
	
	@Override
	public int save(OrderDO order){
		return orderDao.save(order);
	}
	
	@Override
	public int update(OrderDO order){
		return orderDao.update(order);
	}
	
	@Override
	public int remove(Long orderId){
		return orderDao.remove(orderId);
	}
	
	@Override
	public int batchRemove(Long[] orderIds){
		return orderDao.batchRemove(orderIds);
	}

	/**
	 * 分页查询
	 * */
	@Override
	public List<OrderDO> pageList(Map<String, Object> map, Integer pageIndex, Integer pageSize) {
		int index = Constant.PAGE_INDEX;//默认页码
		int size = Constant.PAGE_SIZE;//默认每页数量
		if(null!=pageIndex&&pageIndex>0){
			index = pageIndex;
		}
		if(null!=pageSize){
			size = pageSize;
		}
		map.put("limit", size);//步长
		map.put("offset", (index-1)*size);//开始索引，页码
		return orderDao.list(map);
	}
	
}
