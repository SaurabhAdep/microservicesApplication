package com.cognizant.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.model.LoginModel;
import com.cognizant.service.LoginService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return ("login");
	}

	@PostMapping("/login")
	public String checkingUserDetails(@Valid @ModelAttribute("loginModel") LoginModel loginModel, BindingResult result,
			Model model, HttpSession session) {
		log.debug("loginModel Details : {}", loginModel);
		try {
			String token = loginService.login(loginModel);
			token = "Bearer " + token;
			log.debug("token : {}",token);
			session.setAttribute("token", token);
			return("redirect:/home");
		} catch (FeignException e) {
			if (e.getMessage().contains("User name")) {
				model.addAttribute("status", "Invalid Credentials!!");
			} else if (e.getMessage().contains("Password is wrong")) {
				model.addAttribute("status", "Invalid Credentials!!");
			} else if (e.getMessage().contains("Invalid Credential")) {
				model.addAttribute("status", "Invalid Credentials!!");
			}
			
			return ("login");
		}
	}
		
	@RequestMapping("/logout")
	public String getLoginPage(HttpSession session) {
		session.invalidate();
		return("redirect:/login");
	}
}
