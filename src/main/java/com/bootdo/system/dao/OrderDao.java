package com.bootdo.system.dao;

import com.bootdo.system.domain.OrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单管理
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-07 15:58:21
 */
@Mapper
public interface OrderDao {

	OrderDO get(Long orderId);
	
	List<OrderDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Long order_id);
	
	int batchRemove(Long[] orderIds);
}
