package com.springdemo.dao;

import java.util.List;
import java.util.Map;

import com.springdemo.dao.impl.PageResult;
import com.springdemo.po.Member;

public interface MemberDao {
	public PageResult<Member> queryPage(Integer currentPage,Integer numPerPage,Member member);
	public List<Member> getMemberList();
	public List<Member> getMemberByName(String memberName);
	public List<Member> memberLogin(String memberName, String password);
	public int addMembers(Member member);
}
