package com.springdemo.service;

import java.util.List;
import java.util.Map;

import com.springdemo.dao.impl.PageResult;
import com.springdemo.po.Admin;
import com.springdemo.po.Member;

public interface MemberService{

	public PageResult<Member> queryPageBusiness(Integer currentPage,Integer numPerPage,Member member);
	/*
	* @获取会员列表 
	*/
	public List<Member> getMemberList();
	/*
	* @获取会员列表 
	*/
	public List<Member> getMemberByName(String memberName);
	/*
	* @会员登录
	*/
	public List<Member> memberLogin(String memberName, String password);
	/*
	* @会员注册
	*/
	public boolean addMembers(Member member);
}
