package com.springdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.springdemo.po.User;

@Repository  
public class UserDaoImpl implements UserDao {  
      
    //@Autowired  
    private JdbcTemplate jdbcTemplate;  
  
    @Override  
    public void register(User user) {  
        String sqlStr = "insert into user(uname,pwd) values(?,?)";  
        Object[] params = new Object[]{user.getUsername(),user.getPassword()};  
        jdbcTemplate.update(sqlStr, params);  
    }  
  
    @Override  
    public User findUserByUserName(String userName) {  
        String sqlStr = "SELECT m.member_id,m.uname FROM es_member m WHERE member_id = ?";  
        final User user = new User();  
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {  
            @Override  
            public void processRow(ResultSet rs) throws SQLException {  
            	user.setAge(rs.getInt("member_id"));  
                user.setPassword(rs.getString("uname"));  
            }  
        });  
        return user;  
    }  
  
}
