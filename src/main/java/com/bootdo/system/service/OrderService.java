package com.bootdo.system.service;

import com.bootdo.system.domain.OrderDO;

import java.util.List;
import java.util.Map;

/**
 * 订单管理
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-11 10:03:13
 */
public interface OrderService {
	
	OrderDO get(Long orderId);
	
	OrderDO get(Map<String, Object> map);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Long orderId);
	
	int batchRemove(Long[] orderIds);
}
