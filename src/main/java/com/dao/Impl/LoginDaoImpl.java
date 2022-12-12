package com.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
    	int count = jdbcTemplate.queryForObject("select count(*) from userslogin where username=? and password=?",Integer.class,username,password);
		if(count==1)
			return true;
		else
    	    return false;
	}
    

}
