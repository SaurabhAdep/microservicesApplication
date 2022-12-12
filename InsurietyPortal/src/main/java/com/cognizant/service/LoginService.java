package com.cognizant.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.LoginModel;


public interface LoginService {
	public Boolean validate(String token);

    public String login(LoginModel model);
    
    public ModelAndView checkStatus(HttpServletRequest request);
}
