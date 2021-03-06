package com.springdemo.service;


import com.springdemo.po.MemberMessage;
import com.springdemo.po.Page;

public interface MessageService {
	/**
	 * 查询后台消息列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getMessageList(int pageNo,int pageSize);
	/**
	 * 删除消息列表
	 * @param id
	 */
	public void removeMessage(int id);
	/**
	 * 会员发送消息
	 * @param message
	 */
	public void addMessage(MemberMessage message);
}
