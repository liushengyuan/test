package com.springdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.GoodsDao;
import com.springdemo.dao.PageDao;
import com.springdemo.po.Goods;
import com.springdemo.po.Goodscla;
import com.springdemo.po.Page;
import com.springdemo.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDao goodsdaoimpl;
	@Autowired
	private PageDao pagedaoimpl;
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

	@Override
	public Page getGoodsPage(int page,int pageSize) {
		// TODO Auto-generated method stub
		return this.pagedaoimpl.showAlbum(page, pageSize);
	}

	@Override
	public void changeGoods(int goods_id, int style) {
		// TODO Auto-generated method stub
		this.goodsdaoimpl.changeGoods(goods_id, style);
	}

	@Override
	public Page getOrderPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return this.pagedaoimpl.getAllOrder(page, pageSize);
	}

	@Override
	public List<Goods> getGoodsInfo(int goods_id) {
		// TODO Auto-generated method stub
		return this.goodsdaoimpl.getGoodsInfo(goods_id);
	}
	
}
