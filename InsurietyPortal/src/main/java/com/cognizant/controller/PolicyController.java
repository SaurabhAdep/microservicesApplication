package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.feign.PolicyClient;
import com.cognizant.model.CreatePolicyRequest;
import com.cognizant.model.IssuePolicyRequest;
import com.cognizant.model.PolicyDetailsResponse;
import com.cognizant.model.ViewPolicyRequest;
import com.cognizant.model.ViewPolicePropertyRequest;
import com.cognizant.payload.MessageResponse;
import com.cognizant.service.ConsumerBusinessService;
import com.cognizant.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PolicyController {
	
	@Autowired
	private PolicyClient PolicyClient; 
	
	@Autowired
	private ConsumerBusinessService consumerBusinessService;

	@Autowired
	private LoginService loginService;

	@RequestMapping("/createPolicy")
	public String getCreatePage(HttpSession session,Model model) {
		log.info("start getCreatePage");
		try {
			String token = (String) session.getAttribute("token");
		if (loginService.validate(token)) {
			model.addAttribute("createPolicy", new CreatePolicyRequest());
			log.info("end getCreatePage");
			return ("createPolicy");
		}
	}catch (Exception e) {
		log.info("end getCreatePage");
		return ("redirect:/login");
	}
		log.info("end getCreatePage");
	return ("redirect:/login");
	}
	
	@PostMapping("/createPolicy")
	public String getCreatePageClient(@Valid @ModelAttribute("createPolicy") CreatePolicyRequest createPolicyRequest,
			BindingResult result,HttpSession session,Model model) {
		log.info("start getCreatePageClient");
		try {
			if (result.hasErrors()) {
			System.out.println("Has errors -----------");
			log.info("end getCreatePageClient");

			return "redirect:/createPolicy";
			}
			String token = (String) session.getAttribute("token");
		if (loginService.validate(token)) {
			model.addAttribute("createPolicy", new CreatePolicyRequest());
			MessageResponse message=PolicyClient.createPolicy(token, createPolicyRequest);
			log.debug("{}",message);
			model.addAttribute("consumerStatus", message.getMessage());
			log.info("end getCreatePageClient");
			return ("ConumserBusinessStatus");
		}
	}catch (Exception e) {
		//e.printStackTrace();
		log.debug("{}",e.getMessage());
		if(e.getMessage().contains("Consumer Details are avalable with Policy Id")){
			model.addAttribute("consumerStatus", "Consumer Details Already are exists");
			log.info("inside already found");
			log.info("end getCreatePageClient");
			return "ConumserBusinessStatus";
		}		
		if(e.getMessage().contains("Invalid Token")){
			log.info("end getCreatePageClient");
			return "invalid";
		}
		model.addAttribute("consumerStatus", "Consumer Details are avalable");
		log.info("inside already found");
		log.info("end getCreatePageClient");
		return "ConumserBusinessStatus";
	}
		log.info("end getCreatePageClient");	
	return ("redirect:/home");
	}
	
	
	
	@RequestMapping("/issuePolicy")
	public String getIssuePage(HttpSession session,Model model) {
		log.info("start getIssuePage");
		try {
			String token = (String) session.getAttribute("token");
		if (loginService.validate(token)) {
			model.addAttribute("issuePolicy", new IssuePolicyRequest());
			log.info("end getIssuePage");
			return ("issuePolicy");
		}
	}catch (Exception e) {
		log.info("end getIssuePage");
		return ("redirect:/login");
	}
	log.info("end getIssuePage");
	return ("redirect:/login");
	}
	
	@PostMapping("/issuePolicy")
	public String getIssuePageClient(@Valid @ModelAttribute("issuePolicy") IssuePolicyRequest issuePolicyRequest,
			BindingResult result,HttpSession session,Model model) {
		log.info("start getIssuePageClient");
		try {
			if (result.hasErrors()) {
			log.debug("Has errors -----------");
			log.info("end getIssuePageClient");
			return "redirect:/issuePolicy";
			}
			String token = (String) session.getAttribute("token");
		if (loginService.validate(token)) {
			model.addAttribute("issuePolicy", new IssuePolicyRequest());
			MessageResponse message=PolicyClient.issuePolicy(token, issuePolicyRequest);
			log.debug("{}",message);
			log.debug("Issue Successfull !!");
			log.info("end getIssuePageClient");
			model.addAttribute("consumerStatus", message.getMessage());
			return ("ConumserBusinessStatus");
		}
	}catch (Exception e) {
		//e.printStackTrace();
		log.debug("{}",e.getMessage());
		if(e.getMessage().contains("Sorry!!, No Consumer Found!!")){
			log.info("end getIssuePageClient");
			return "ConsumerNotFound";
		}
		if(e.getMessage().contains("Sorry!!, No Policy Found!!")){
			log.info("end getIssuePageClient");
			return("PolicyNotFound");
		}
		if(e.getMessage().contains("Sorry!!, Payment Failed!! Try Again")){
			log.info("end getIssuePageClient");
			return("PaymentFailed");
		}
		if(e.getMessage().contains("Details are mismatched")){
			model.addAttribute("consumerStatus", "Details are mismatched");
			log.info("end getCreatePageClient");
			return ("ConumserBusinessStatus");
		}
		if(e.getMessage().contains("Already Saved")){
			model.addAttribute("consumerStatus", "Details are Already Saved");
			log.info("end getCreatePageClient");
			return ("ConumserBusinessStatus");
		}
		if(e.getMessage().contains("Sorry!!, No Consumer Found!!")){
			log.info("end getIssuePageClient");
			return("AcceptedFailed");
		}
		log.info("end getIssuePageClient");
		return ("redirect:/home");
	}
		log.info("end getIssuePageClient");
	return ("redirect:/home");
	}

	
	
	@RequestMapping("/viewPolicy")
	public String getViewpage(HttpSession session,Model model) {
		log.info("start getViewpage");
		try {
			String token = (String) session.getAttribute("token");
		if (loginService.validate(token)) {
			model.addAttribute("viewPolicy", new ViewPolicePropertyRequest());
			log.info("end getViewpage");
			return ("viewPolicy");
		}
	}catch (Exception e) {
		e.printStackTrace();
		log.info("end getViewpage");
		return ("redirect:/login");
	}
	log.info("end getViewpage");
	return ("redirect:/login");
	}
	
	@RequestMapping("/viewExistingPolicy")
	public String getExistingViewpage(HttpSession session,Model model) {
		log.info("start getViewpage");
		try {
			String token = (String) session.getAttribute("token");
		if (loginService.validate(token)) {
			model.addAttribute("viewPolicy", new ViewPolicyRequest());
			log.info("end getViewpage");
			return ("viewExistingPolicy");
		}
	}catch (Exception e) {
		e.printStackTrace();
		log.info("end getViewpage");
		return ("redirect:/login");
	}
	log.info("end getViewpage");
	return ("redirect:/login");
	}
	
	@PostMapping("/viewPolicy")
	public String getViewPageClient(@Valid @ModelAttribute("viewPolicy") ViewPolicyRequest viewPolicyRequest,
			BindingResult result,HttpSession session,Model model) {
		log.info("start getViewPageClient");
		try {
			if (result.hasErrors()) {
			System.out.println("Has errors -----------");
			System.out.println(result.getAllErrors());
			log.info("end getViewPageClient");
			return "redirect:/viewPolicy";
			}
			String token = (String) session.getAttribute("token");
		if (loginService.validate(token)) {
			model.addAttribute("viewPolicy", new ViewPolicyRequest());
			PolicyDetailsResponse policyDetailsResponse=PolicyClient.viewPolicy(token, viewPolicyRequest.getConsumerid(),viewPolicyRequest.getPolicyid());
			model.addAttribute("PolicyDetailsResponse", policyDetailsResponse);
			log.debug("{}",policyDetailsResponse);
			log.info("end getViewPageClient");
			return ("viewPolicyResponce");
		}
	}catch (Exception e) {
		log.info("end getViewPageClient");
		e.printStackTrace();
		if(e.getMessage().contains("Details Not Found with these")){
			model.addAttribute("consumerStatus", "Details are Not Found");
			log.info("end getViewPageClient");
			return ("ConumserBusinessStatus");
		}
		if(e.getMessage().contains("Invalid Token")){
			return "invalid";
		}
		if(e.getMessage().contains("Sorry!!, No Policy Found!!")){
			return "PolicyNotFound";
		}
		if(e.getMessage().contains("Sorry!!, No Consumer Found!!")){
			return "ConsumerNotFound";
		}
		
		return ("redirect:/home");
	}
		log.info("end getViewPageClient");
	return ("redirect:/home");
	}
	
	
	@PostMapping("/GetPolicyDetails")
	public String GetPolicyDetails(@Valid @ModelAttribute("viewPolicy") ViewPolicePropertyRequest viewPolicePropertyRequest,
			BindingResult result, HttpSession session,
			Model model/* ,@RequestParam long consumerId,@RequestParam long propertyId */) {
		log.info("start GetPolicyDetails");
		try {
			if (result.hasErrors()) {
			log.debug("Has errors -----------");
			log.info("end GetPolicyDetails");
			return "redirect:/viewPolicy";
			}
			String token = (String) session.getAttribute("token");
		if (loginService.validate(token)) {
			model.addAttribute("viewPolicy", viewPolicePropertyRequest);
			if(viewPolicePropertyRequest.getPoliceId() != null) {
				String policyId = viewPolicePropertyRequest.getPoliceId();
				log.debug("{}",policyId);
//				PolicyDetailsResponse policyDetailsResponse = PolicyClient.viewPolicy(token, viewPolicePropertyRequest.getConsumerId(), policyId);
//				model.addAttribute("policyDetailsResponse", policyDetailsResponse);
				log.debug("policyId  {}",policyId);
				log.debug("{}",viewPolicePropertyRequest.getConsumerId());
				log.debug("{}",viewPolicePropertyRequest.getPropertyId());
				String quote = consumerBusinessService.getQuote(token, policyId, viewPolicePropertyRequest.getConsumerId(), viewPolicePropertyRequest.getPropertyId());
				log.debug("{}",quote);
				if(!quote.equalsIgnoreCase("No Quotes, Contact Insurance Provider")) {
					model.addAttribute("createPolicy", new CreatePolicyRequest(viewPolicePropertyRequest.getConsumerId(), quote,viewPolicePropertyRequest.getPoliceId()));
					log.info("end GetPolicyDetails");
					return ("createPolicy");
				}
				else {
					model.addAttribute("policStatus", "No Quotes, Contact Insurance Provider");
				}
			}
			List<String> polices = PolicyClient.getPolices(token, viewPolicePropertyRequest.getConsumerId(),viewPolicePropertyRequest.getPropertyId());
			log.debug("{}",polices);
			if(polices.isEmpty()) {
				model.addAttribute("policStatus", "Polices Not Found");
			}
			model.addAttribute("policies", polices);
			log.info("end GetPolicyDetails");
			return ("viewPolicy");
		}
	}catch (Exception e) {
		log.debug("{}",e.getMessage());
		if(e.getMessage().contains("Sorry!!, No Consumer Found!!")){
			log.info("end GetPolicyDetails");
			return "ConsumerNotFound";
		}
		if(e.getMessage().contains("Sorry!!, No Policy Found!!")){
			log.info("end GetPolicyDetails");
			return("PolicyNotFound");
		}
		if(e.getMessage().contains("Sorry!!, No Property Found!!")){
			log.info("end GetPolicyDetails");
			return("PropertyNotFound");
		}
		log.info("end GetPolicyDetails");
		return ("redirect:/home");
	}
		log.info("end GetPolicyDetails");
	return ("redirect:/home");
	}
}