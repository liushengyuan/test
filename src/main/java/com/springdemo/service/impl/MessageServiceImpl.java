package com.springdemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.PageDao;
import com.springdemo.po.Page;
import com.springdemo.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private PageDao pagedaoimpl;
	@Override
	public Page getMessageList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.pagedaoimpl.showMessage(pageNo, pageSize);
	}

}
