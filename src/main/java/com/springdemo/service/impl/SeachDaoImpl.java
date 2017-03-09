package com.springdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.service.SeachDao;
@Service
public class SeachDaoImpl implements SeachDao{

	@Autowired
	private SeachDao seachdaoimpl;
	@Override
	public List getSeachGoodsList(Integer cla, Integer child_cla,
			Integer three_cla, String keyword) {
		// TODO Auto-generated method stub
		return this.seachdaoimpl.getSeachGoodsList(cla, child_cla, three_cla, keyword);
	}

}
