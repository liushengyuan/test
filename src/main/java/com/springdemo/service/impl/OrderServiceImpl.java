package com.springdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.OrderDao;
import com.springdemo.po.Order;
import com.springdemo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderdaoimpl;
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		this.orderdaoimpl.addOrder(order);
	}

}
