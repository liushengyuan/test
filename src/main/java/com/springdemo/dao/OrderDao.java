package com.springdemo.dao;

import com.springdemo.po.Order;

public interface OrderDao {
	/**
	 * 添加订单
	 * @param order
	 */
	public void addOrder(Order order);
	
}
