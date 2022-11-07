package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.feign.ConsumerClient;
import com.cognizant.model.Property;
import com.cognizant.payload.BusinessPropertyRequest;
import com.cognizant.payload.viewPropertyRequest;
import com.cognizant.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BusinessPropertyController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private ConsumerClient buinessPropertyProxy;

	@RequestMapping("/createBusinessProperty")
	public String getCreatePropertyPage(
			@ModelAttribute("businessPropertyRequest") BusinessPropertyRequest businessPropertyRequest,
			HttpSession session) {
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
				return ("createBusinessProperty");
			}
		} catch (Exception e) {
			return ("redirect:/login");
		}
		return ("redirect:/login");
	}

//	@RequestMapping("/viewBusinessProperty")
//	public String getViewPropertyPage(@ModelAttribute("viewPropertyRequest") viewPropertyRequest viewPropertyRequest,Long consmerId,Long propertyId,HttpSession session,Model map) {
//		try {
//			String token = (String) session.getAttribute("token");
//			if (loginService.validate(token)) {
//				map.addAttribute("p",map.getAttribute("p"));
//				return ("viewBusinessProperty");
//			}
//		} catch (Exception e) {
//			return ("redirect:/login");
//		}
//		return ("redirect:/login");
//	}
	
	@RequestMapping("/viewBusinessProperty")
	public String getViewPropertyPage(@ModelAttribute("viewPropertyRequest") viewPropertyRequest viewPropertyRequest,HttpSession session,Model map) {
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
//				map.addAttribute("p",map.getAttribute("p"));
//				List<Property> propertyList = buinessPropertyProxy.viewConsumerProperty(token, viewPropertyRequest.getConsumerId());
				return ("viewBusinessProperty");
			}
		} catch (Exception e) {
			return ("redirect:/login");
		}
		return ("redirect:/login");
	}
	
	@RequestMapping(value="/viewPropertyAll",method = RequestMethod.POST)
	public String viewPropertyAll(
			@Valid @ModelAttribute("viewPropertyRequest") viewPropertyRequest viewPropertyRequest,BindingResult result,
			Model map, HttpSession session) {
		try {
			if (result.hasErrors()) {
				System.out.println("Has errors -----------");
				return "redirect:/viewBusinessProperty";
			}
			String token = (String) session.getAttribute("token");
			System.out.println(token);
			if (loginService.validate(token)) {
				List<Property> property=buinessPropertyProxy.viewConsumerProperty(token, viewPropertyRequest.getConsumerId());
				map.addAttribute("consumerId",viewPropertyRequest.getConsumerId());
				map.addAttribute("property",property);
				System.out.println(property.toString());
				return "viewBusinessProperty";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(e.getMessage().contains("Sorry!!, No Consumer Found!!")) {
				return("ConsumerNotFound");
			}
			if(e.getMessage().contains("No value present")) {
				return("PropertyNotFound");
			}
			return ("redirect:/home");
		}
		return ("redirect:/home");
	}

	@RequestMapping("/updateBusinessProperty")
	public String getUpdatePropertyPage(@ModelAttribute("businessPropertyRequest") BusinessPropertyRequest businessPropertyRequest,HttpSession session,
			@RequestParam("consumerId") Long consumerId,@RequestParam("propertyId") long propertyId,Model model) {
		try {
			String token = (String) session.getAttribute("token");
			if (loginService.validate(token)) {
				Property property = buinessPropertyProxy.viewConsumerProperty(token, consumerId,propertyId);
				BusinessPropertyRequest bps = new BusinessPropertyRequest(property.getId(), consumerId, property.getInsuranceType(), property.getPropertyType(), property.getBuildingSqft(), property.getBuildingType(), property.getBuildingStoreys(), property.getBuildingAge(), property.getCostOfTheAsset(), property.getSalvageValue(), property.getUsefulLifeOfTheAsset());
				model.addAttribute("businessPropertyRequest", bps);
				return ("updateBusinessProperty");
			}
		} catch (Exception e) {
			
			return ("redirect:/login");
		}
		return ("redirect:/login");
	}

	@RequestMapping(value="/createProperty", method = RequestMethod.POST)
	public String createProperty(
			@Valid @ModelAttribute("businessPropertyRequest") BusinessPropertyRequest businessPropertyRequest,
			BindingResult result, HttpSession session,Model map,RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				System.out.println("Has errors -----------");
				log.debug("errors : {}",result.getAllErrors());
				return "redirect:/createBusinessProperty";
			}
			System.out.println(businessPropertyRequest.toString());
			String token = (String) session.getAttribute("token");
			System.out.println(token);
			if (loginService.validate(token)) {
				String msg=buinessPropertyProxy.createBusinessProperty(token, businessPropertyRequest);
//				map.addAttribute("msg",msg);
//				System.out.println(msg);
//				return "createResponse";
				redirectAttributes.addFlashAttribute("consumerStatus", msg);
				return("redirect:/status");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ("redirect:/home");
		}
		return ("redirect:/createResponse");
	}
	
	@RequestMapping(value="/updateProperty", method = RequestMethod.POST)
	public String updateProperty(
			@Valid @ModelAttribute("businessPropertyRequest") BusinessPropertyRequest businessPropertyRequest,
			BindingResult result, HttpSession session,Model map,RedirectAttributes redirectAttributes) {
		try {
			if (result.hasErrors()) {
				System.out.println("Has errors -----------");
				return "redirect:/updateBusinessProperty";
			}
			System.out.println(businessPropertyRequest.toString());
			String token = (String) session.getAttribute("token");
			System.out.println(token);
			if (loginService.validate(token)) {
				String msg=buinessPropertyProxy.updateBusinessProperty(token, businessPropertyRequest);
				log.debug("msg : {}",msg);
//				map.addAttribute("msg",msg);
//				return "createResponse";
				redirectAttributes.addFlashAttribute("consumerStatus", msg);
				return("redirect:/status");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(e.getMessage().contains("Sorry!!, No Consumer Found!!")) {
				return("ConsumerNotFound");
			}
			if(e.getMessage().contains("No value present")) {
				return("PropertyNotFound");
			}
			return ("redirect:/home");
		}
		return ("redirect:/home");
	}
	@RequestMapping(value="/viewProperty",method = RequestMethod.POST)
	public String viewProperty(
			@Valid @ModelAttribute("viewPropertyRequest") viewPropertyRequest viewPropertyRequest,BindingResult result,
			Model map, HttpSession session) {
		try {
			if (result.hasErrors()) {
				System.out.println("Has errors -----------");
				return "redirect:/viewBusinessProperty";
			}
			String token = (String) session.getAttribute("token");
			System.out.println(token);
			if (loginService.validate(token)) {
				Property property=buinessPropertyProxy.viewConsumerProperty(token, viewPropertyRequest.getConsumerId(),viewPropertyRequest.getPropertyId());
				map.addAttribute("p",property);
				System.out.println(property.toString());
				return "viewProperty";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(e.getMessage().contains("Sorry!!, No Consumer Found!!")) {
				return("ConsumerNotFound");
			}
			if(e.getMessage().contains("No value present")) {
				return("PropertyNotFound");
			}
			return ("redirect:/home");
		}
		return ("redirect:/home");
	}
	@RequestMapping("/createResponse")
	public String viewResponse(
			Model map, HttpSession session) {
		try {
			String token = (String) session.getAttribute("token");
			System.out.println(token);
			if (loginService.validate(token)) {
				return "redirect:/createBusinessProperty";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ("redirect:/createBusinessProperty");
		}
		return ("redirect:/createBusinessProperty");
	}

}
