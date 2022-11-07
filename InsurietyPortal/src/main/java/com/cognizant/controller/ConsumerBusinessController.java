package com.cognizant.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.payload.ConsumerBusinessRequest;
import com.cognizant.payload.ConsumerBusinessResponse;
import com.cognizant.service.ConsumerBusinessService;
import com.cognizant.service.LoginService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ConsumerBusinessController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private ConsumerBusinessService consumerBusinessService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, false));
	}

	@GetMapping("viewConsumerBusiness")
	public String viewConsumerBusiness(HttpSession session, Model model) {
		log.info("start get viewConsumerBusinessDetails");
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
				model.addAttribute("ConsumerBusinessResponse", new ConsumerBusinessResponse());
				log.info("end get viewConsumerBusinessDetails");
				return ("viewConsumerBusiness");
			}
			return ("redirect:/login");
		} catch (FeignException e) {
			log.info("end get viewConsumerBusinessDetails");
			return ("invalid");
		}
	}

	@PostMapping("viewConsumerBusiness")
	public String viewConsumerBusinessDetails(
			@ModelAttribute("ConsumerBusinessResponse") ConsumerBusinessResponse consumerBusinessResponse,
			HttpSession session, Model model) {
		log.info("start Post viewConsumerBusinessDetails");
		try {
			String token = (String) session.getAttribute("token");
			ConsumerBusinessResponse consumerDetails = consumerBusinessService.viewConsumerBusiness(token,
					consumerBusinessResponse.getConsumerID());
			log.debug("ConsumerBusinessResponse : {}", consumerDetails);
			model.addAttribute("consumerDetails", consumerDetails);
			log.info("end Post viewConsumerBusinessDetails");
			return ("viewConsumerBusiness");
		} catch (FeignException e) {
			log.info("end Post viewConsumerBusinessDetails");
			String message = e.getMessage();
			log.debug("message is : {}", message);
			if (message.contains("Sorry!!, No Consumer Found!!")) {
				log.info("matched");
				return ("ConsumerNotFound");
			}
			return ("invalid");
		}
	}

	@GetMapping("createConsumerBusiness")
	public String createConsumerBusiness(HttpSession session, Model model) {
		log.info("start get createConsumerBusinessDetails");
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
				model.addAttribute("ConsumerBusinessRequest", new ConsumerBusinessRequest());
				log.info("end get createConsumerBusinessDetails");
				return ("createConsumerBusiness");
			}
			return ("redirect:/login");
		} catch (FeignException e) {
			log.info("end get createConsumerBusinessDetails");
			return ("invalid");
		}
	}

	@PostMapping("createConsumerBusiness")
	public String createConsumerBusinessDetails(
			@Valid @ModelAttribute("ConsumerBusinessRequest") ConsumerBusinessRequest consumerBusinessRequest,
			BindingResult result, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		log.info("start Post createConsumerBusinessDetails");
		if (result.hasErrors()) {
			log.debug("{}", result.getAllErrors());
			return ("createConsumerBusiness");
		}
		try {
			String token = (String) session.getAttribute("token");
			String response = consumerBusinessService.createConsumerBusiness(token, consumerBusinessRequest);
			log.debug("ConsumerBusinessRequest : {}", response);
			redirectAttributes.addFlashAttribute("consumerStatus", response);
			return("redirect:/status");
		} catch (FeignException e) {
			if (e.getMessage().contains("consumer already Exists")) {
				model.addAttribute("consumerStatus", "consumer Details already Found");
				return("ConumserBusinessStatus");
			}
			log.info("end Post createConsumerBusinessDetails");
			return ("invalid");
		}
	}
	
	@GetMapping("status")
	public String Consumerstatus(HttpSession session, Model model) {
		log.info("start Consumerstatus");
		model.addAttribute("consumerStatus", model.asMap().get("consumerStatus"));
		log.info("end Consumerstatus");
		return("ConumserBusinessStatus");	
	}

	@GetMapping("updateConsumerBusiness")
	public String updateConsumerBusiness(HttpSession session, Model model) {
		log.info("start get updateConsumerBusinessDetails");
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
				model.addAttribute("ConsumerBusinessResponse", new ConsumerBusinessResponse());
				model.addAttribute("ConsumerBusinessRequest", new ConsumerBusinessRequest());
				log.info("end get updateConsumerBusinessDetails");
				return ("updateConsumerBusiness");
			}
			return ("redirect:/login");
		} catch (FeignException e) {
			log.info("end get updateConsumerBusinessDetails");
			return ("invalid");
		}
	}

	@PostMapping("update-ConsumerBusiness")
	public String updateConsumerBusinessDetails(
			@Valid @ModelAttribute("ConsumerBusinessRequest") ConsumerBusinessRequest consumerBusinessRequest,
			BindingResult result, HttpSession session, Model model,RedirectAttributes redirectAttributes) {
		log.info("start Post updateConsumerBusinessDetails");
		if (result.hasErrors()) {
			log.debug("{}", result.getAllErrors());
			return ("updateConsumerBusiness");
		}
		try {
			String token = (String) session.getAttribute("token");
			String response = consumerBusinessService.updateConsumerBusiness(token, consumerBusinessRequest);
			log.debug("ConsumerBusinessRequest : {}", response);
//			model.addAttribute("consumerStatus", response);
//			log.info("end Post viewConsumerBusinessDetails");
//			return ("ConumserBusinessStatus");
			redirectAttributes.addFlashAttribute("consumerStatus", response);
			return("redirect:/status");
		} catch (FeignException e) {
			String message = e.getMessage();
			log.debug("message is : {}", message);
			if (message.contains("Sorry!!, No Consumer Found!!")) {
				log.info("matched");
				return ("ConsumerNotFound");
			}
			log.info("end Post updateConsumerBusinessDetails");
			return ("invalid");
		}
	}

	@PostMapping("getDetails")
	public String getDetails(
			@ModelAttribute("ConsumerBusinessResponse") ConsumerBusinessResponse consumerBusinessResponse,
			HttpSession session, Model model) {
		log.info("start  getDetails");
		try {
			String token = (String) session.getAttribute("token");
			ConsumerBusinessRequest consumerDetails = consumerBusinessService.getDetailsForUpdate(token,
					consumerBusinessResponse.getConsumerID());
			log.debug("ConsumerBusinessRequest : {}", consumerDetails);
			model.addAttribute("ConsumerBusinessRequest", consumerDetails);
			log.info("end  getDetails");
			return ("updateConsumerBusiness");
		} catch (FeignException e) {
			log.info("end Post viewConsumerBusinessDetails");
			String message = e.getMessage();
			log.debug("message is : {}", message);
			if (message.contains("Sorry!!, No Consumer Found!!")) {
				log.info("matched");
				log.info("end  getDetails");
				return ("ConsumerNotFound");
			}
			log.info("end  getDetails");
			return ("invalid");
		}
	}
}
