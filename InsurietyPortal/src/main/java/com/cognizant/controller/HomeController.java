package com.cognizant.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.service.LoginService;

@Controller
public class HomeController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/home")
	public String getPage(HttpSession session) {
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
				return ("home");
			}
		} catch (Exception e) {
			return ("redirect:/login");
		}
		return ("redirect:/login");
	}
}
