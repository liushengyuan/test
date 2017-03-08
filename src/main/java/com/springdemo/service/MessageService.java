package com.springdemo.service;


import com.springdemo.po.Page;

public interface MessageService {
	/**
	 * 查询后台消息列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getMessageList(int pageNo,int pageSize);
}
