package com.springdemo.service;

import com.springdemo.po.Order;

public interface OrderService {
	/**
	 * 下订单
	 * @param order
	 */
	public void addOrder(Order order);
}
