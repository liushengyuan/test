package com.springdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.impl.PageResult;
import com.springdemo.po.Admin;
import com.springdemo.po.Member;
import com.springdemo.po.User;

@Repository
public class MemberDaoImpl implements MemberDao{
	//@Autowired  
    private JdbcTemplate jdbcTemplate;
    @Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

    public PageResult<Member> queryPage(Integer currentPage,Integer numPerPage,Member member){
        StringBuffer sql=new StringBuffer();
        sql.append("select * from zd_member where 1=1");
        //sql.append("select tid, tno,tname,dno from teacher where 1=1 ");
//        if(teacher!=null){
//            if(teacher.getTname()!=null && !teacher.getTname().equals("")){
//                sql.append(" and tname like '");
//                sql.append(teacher.getTname());
//                sql.append("%' ");
//            }
//            if(teacher.getDno()!=null && !teacher.getDno().equals("")){
//                sql.append(" and dno like '");
//                sql.append(teacher.getDno());
//                sql.append("%' ");
//            }
//        }
//        sql.append(" order by tno asc");
        PageResult<Member> page = new PageResult<Member>(sql.toString(),currentPage,numPerPage,this.simpleJdbcTemplate);
        return page;
    }
	@Override 
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * from zd_member";  
		String param = null;
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		List<Member> list = this.simpleJdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Member.class));
		return list;
	}

	@Override
	public int addMembers(Member member) {
		// TODO Auto-generated method stub
		String sql = "insert into zd_member(memberName,password,address,mobile,ifFrozenAccount,createDate) values(?,?,?,?,?,?)";  
        //Object[] params = new Object[]{user.getUsername(),user.getPassword()};  
		this.simpleJdbcTemplate.update(sql,member.getMemberName(),
				member.getPassword(),member.getAddress(),member.getMobile(),member.getIfFrozenAccount(),member.getCreateDate());
		return 1;
	}

	@Override
	public List<Member> getMemberByName(String memberName) {
		String sql = "SELECT * from zd_member where memberName = ?";  
		String param = null;
		// TODO Auto-generated method stub
		
		@SuppressWarnings("deprecation")
		List<Member> list = this.simpleJdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Member.class),memberName);
		return list;
	}

	@Override
	public List<Member> memberLogin(String memberName, String password) {
		
		String sql = "SELECT * from zd_member where memberName = ? AND password = ?";  
		String param = null;
		// TODO Auto-generated method stub
		
		@SuppressWarnings("deprecation")
		List<Member> list = this.simpleJdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Member.class),memberName,password);
		return list;
	}
    
    
}
