package com.springdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.GoodsDao;
import com.springdemo.po.Goods;
import com.springdemo.po.Goodscla;
import com.springdemo.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDao goodsdaoimpl;
	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		this.goodsdaoimpl.addGoods(goods);
	}
	
	@Override
	public int lastGoodsid() {
		// TODO Auto-generated method stub
		int goods_id =this.goodsdaoimpl.getLastGoodsid();
		return goods_id;
	}

	@Override
	public void addGoodscla(Goodscla Goodscla) {
		// TODO Auto-generated method stub
		this.goodsdaoimpl.addGoodscla(Goodscla);
	}
	
}
