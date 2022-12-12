package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.LoginDao;

@Controller
public class LoginController {
    
	@Autowired
	LoginDao logindao;
	
	@GetMapping("/login")
	public String getLogin(){
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String checkUser(@RequestParam("username") String username,@RequestParam("password") String password){
		boolean loginFlag = logindao.validateUser(username, password);
		if(loginFlag==true)
			return "success";
		else
			return "failure";
	}
}
