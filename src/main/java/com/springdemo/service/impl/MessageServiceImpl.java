package com.springdemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.MessageDao;
import com.springdemo.dao.PageDao;
import com.springdemo.po.MemberMessage;
import com.springdemo.po.Page;
import com.springdemo.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private PageDao pagedaoimpl;
	
	@Autowired
	private MessageDao messagedaoimpl;
	
	@Override
	public Page getMessageList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.pagedaoimpl.showMessage(pageNo, pageSize);
	}
	
	@Override
	public void removeMessage(int id) {
		// TODO Auto-generated method stub
		this.messagedaoimpl.removeMessage(id);
	}

	@Override
	public void addMessage(MemberMessage message) {
		// TODO Auto-generated method stub
		this.messagedaoimpl.addMessage(message);
	}

}
