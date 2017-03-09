package com.springdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.ActDao;
import com.springdemo.service.ActService;

@Service
public class ActServiceImpl implements ActService{
	
	@Autowired
	private ActDao actdaoimpl;
	
	@Override
	public void delActGoods(int act_id, int goods_id) {
		// TODO Auto-generated method stub
		this.actdaoimpl.delActGoods(act_id, goods_id);
	}

	@Override
	public void addActGoods(int act_id, int goods_id) {
		// TODO Auto-generated method stub
		this.actdaoimpl.addActGoods(act_id, goods_id);
	}

	@Override
	public List getActGoods() {
		// TODO Auto-generated method stub
		return this.actdaoimpl.getActGoodsList();
	}

}
