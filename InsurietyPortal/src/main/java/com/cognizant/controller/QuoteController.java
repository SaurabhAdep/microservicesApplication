package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.feign.PolicyClient;
import com.cognizant.payload.ConsumerBusinessResponse;
import com.cognizant.payload.QuotesMaster;
import com.cognizant.payload.ViewQuotes;
import com.cognizant.service.LoginService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class QuoteController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PolicyClient policyRest;
	
	@GetMapping("quote")
	public String getQuote(HttpSession session,Model model) {
		log.info("start get getQuote");
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
				model.addAttribute("quote", new ViewQuotes());
				log.info("end get getQuote");
				return ("quotes");
			}
			return("redirect:/login");
		}catch(FeignException e) {
			log.info("end get getQuote");
			return("invalid");
		}
	}
	
	@PostMapping("quote")
	public String viewQuote(@Valid @ModelAttribute("quote") ViewQuotes viewQuotes,BindingResult result,HttpSession session,Model model) {
		log.info("start Post viewQuote");
		try {
			if(result.hasErrors()) {
				return("quotes");
			}
			String token = (String) session.getAttribute("token");
			String quote = policyRest.getQuotes(token,viewQuotes.getBusinessValue(),viewQuotes.getPropertyValue(),viewQuotes.getPropertyType()).getQuotes();
			quote = "Current Quote : "+ quote; 
			log.debug("ConsumerBusinessResponse : {}",quote);
			model.addAttribute("quote", viewQuotes);
			model.addAttribute("quoteStatus", quote);
			log.info("end Post viewQuote");
			return("quotes");
		}catch(FeignException e) {
			e.printStackTrace();
			log.info("end Post viewQuote");
			return("invalid");
		}
	}
	
	@GetMapping("allQuotes")
	public String getAllQuotes(HttpSession session,Model model) {
		log.info("start get getAllQuotes");
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
				List<QuotesMaster> quotes = null;
				model.addAttribute("allQuotes", quotes);
				log.info("end get getAllQuotes");
				return ("allQuotes");
			}
			return("redirect:/login");
		}catch(FeignException e) {
			log.info("end get getAllQuotes");
			return("invalid");
		}
	}
}
