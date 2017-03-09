package com.springdemo.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.MemberDao;
import com.springdemo.dao.impl.PageResult;
import com.springdemo.po.Admin;
import com.springdemo.po.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public PageResult<Member> queryPageBusiness(Integer currentPage,
			Integer numPerPage, Member member) {
		// TODO Auto-generated method stub
		return memberDao.queryPage(currentPage,numPerPage,member);
	}
	
	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		
		try {
			List<Member> list = this.memberDao.getMemberList();
			//Collections.sort(list, Collections.reverseOrder());
			Collections.reverse(list);
			return list;
		} catch (Exception e) {
			// TODO: handle ex66ception
		}
		
		return null;
	}

	@Override
	public boolean addMembers(Member member) {
		// TODO Auto-generated method stub
		
		int count = this.memberDao.addMembers(member);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Member> getMemberByName(String memberName) {
		// TODO Auto-generated method stub
		try {
			List<Member> list = this.memberDao.getMemberByName(memberName);
			//Collections.sort(list, Collections.reverseOrder());
			//Collections.reverse(list);倒序输出
			return list;
		} catch (Exception e) {
			// TODO: handle ex66ception
		}
		
		return null;
	}

	@Override
	public List<Member> memberLogin(String memberName, String password) {
		// TODO Auto-generated method stub
		try {
			List<Member> list = this.memberDao.memberLogin(memberName, password);
			//Collections.sort(list, Collections.reverseOrder());
			//Collections.reverse(list);倒序输出
			return list;
		} catch (Exception e) {
			// TODO: handle ex66ception
		}
		return null;
	}

	
	
}
