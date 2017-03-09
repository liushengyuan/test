package com.springdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.GoodsClaDao;
import com.springdemo.service.SeachService;
@Service
public class SeachServiceImpl implements SeachService{

	@Autowired
	private GoodsClaDao goodscladaoImpl;
	@Override
	public List getSeachGoodsList(Integer cla, Integer child_cla,
			Integer three_cla, String keyword) {
		// TODO Auto-generated method stub
		return this.goodscladaoImpl.getGoodsCla(cla, child_cla, three_cla, keyword);
	}

}
