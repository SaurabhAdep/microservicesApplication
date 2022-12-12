package com.cognizant.pas.policy.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pas.policy.exception.ConsumerBusinessNotFoundException;
import com.cognizant.pas.policy.exception.InvalidTokenException;
import com.cognizant.pas.policy.payload.request.CreatePolicyRequest;
import com.cognizant.pas.policy.payload.request.IssuePolicyRequest;
import com.cognizant.pas.policy.payload.response.MessageResponse;
import com.cognizant.pas.policy.payload.response.PolicyDetailsResponse;
import com.cognizant.pas.policy.payload.response.QuotesDetailsResponse;
import com.cognizant.pas.policy.repository.ConsumerPolicyRepository;
import com.cognizant.pas.policy.repository.PolicyMasterRepository;
import com.cognizant.pas.policy.restclients.AuthClient;
import com.cognizant.pas.policy.service.PolicyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for Policy service
 */
@RestController

public class PolicyController {

static Logger log = Logger.getLogger(PolicyController.class);
	
	public PolicyController() {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}
	@Autowired
	PolicyService policyService;

	@Autowired
	PolicyMasterRepository policyMasterRepository;
	
	@Autowired
	ConsumerPolicyRepository consumerPolicyRepository;
	
	@Autowired
	private AuthClient authClient;
	
	/*
	* @throws Exception  If an input or output 
	*                      exception occurred
	*/
	
	private static final String CNF="Sorry!!, No Consumer Found!!";
	private static final String PNF="Sorry!!, No Policy Found!!";
	private static final String IT="Invalid token";

	/*
	 * this method used to create the policy Based on consumerId,accepted Quotes and policeId.
	 */
	@PostMapping("/createPolicy")
	public ResponseEntity<MessageResponse> createPolicy(
			@RequestHeader(name = "Authorization") String token,@Valid @RequestBody CreatePolicyRequest createPolicyRequest) throws InvalidTokenException {
		log.info("Start createPolicy");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}
		MessageResponse messageResponse = policyService.createPolicy(token,createPolicyRequest);
		log.debug("MessageResponse : {}"+ messageResponse);
		log.info("End createPolicy");
		return (new ResponseEntity<>(messageResponse, HttpStatus.CREATED));
	}

	/*
	 *this method used to issue the policy Based on policyId,consumerId,businessIdpaymentDetails and acceptanceStatus. 
	 */
	
	@PostMapping("/issuePolicy")
	@HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
	public ResponseEntity<MessageResponse> issuePolicy(@RequestHeader(name = "Authorization") String token,@Valid @RequestBody IssuePolicyRequest issuePolicyRequest) throws InvalidTokenException {
		log.info("Start issuePolicy");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}
		if (Boolean.FALSE.equals(consumerPolicyRepository.existsByConsumerId(issuePolicyRequest.getconsumerId()))) {
			log.error(CNF);
			return (new ResponseEntity<>(new MessageResponse(CNF),HttpStatus.NOT_FOUND));
		}
		if (Boolean.FALSE.equals(policyMasterRepository.existsByPid(issuePolicyRequest.getpolicyId()))) {
			log.error(PNF);
			return (new ResponseEntity<>(new MessageResponse(PNF),HttpStatus.NOT_FOUND));
		}
		if (Boolean.FALSE.equals(issuePolicyRequest.getpaymentDetails().equalsIgnoreCase("success"))) {
			log.error("Sorry!!! Payment failed");
			return (new ResponseEntity<>(new MessageResponse("Sorry!!, Payment Failed!! Try Again"),HttpStatus.NOT_FOUND));
		}
		if (Boolean.FALSE.equals(issuePolicyRequest.getacceptanceStatus().equalsIgnoreCase("accepted"))) {
			log.error("Sorry !!! accepted failed");
			return (new ResponseEntity<>(new MessageResponse("Sorry!!, Accepted Failed !! Try Again"),HttpStatus.NOT_FOUND));
		}
		MessageResponse messageResponse = policyService.issuePolicy(issuePolicyRequest);
		log.debug("MessageResponse : {}"+messageResponse);
		log.info("End issuePolicy");
		return (new ResponseEntity<>(messageResponse, HttpStatus.OK));
	}

	/*
	 * this method used to view the policy based on consumer id and policy id.
	 */
	
	@GetMapping("/viewPolicy")
	@HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
	public ResponseEntity<PolicyDetailsResponse> viewPolicy(@RequestHeader(name = "Authorization") String token,@Valid @RequestParam Long consumerid, @RequestParam String policyid) throws InvalidTokenException,ConsumerBusinessNotFoundException {
		log.info("Start viewPolicy");
		log.info("consumerId "+consumerid);
		log.info("policyId "+policyid);
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}
		if (Boolean.FALSE.equals(policyMasterRepository.existsByPid(policyid))) {
			log.error(PNF);
			throw new ConsumerBusinessNotFoundException(PNF);
		}
		if(Boolean.FALSE.equals(consumerPolicyRepository.existsByConsumerId(consumerid))) {
			log.error(CNF);
			throw new ConsumerBusinessNotFoundException(CNF);
		}	
		PolicyDetailsResponse policyDetailsResponse = policyService.viewPolicy(consumerid, policyid);
		log.debug("PolicyDetailsResponse: {}"+policyDetailsResponse);
		log.info("End viewPolicy");
		return ResponseEntity.ok(policyDetailsResponse);
	}
	

	/*
	 * this method used to display the Quotes details based on businessValue,propertyValue and propertyType.
	 */
	
	@GetMapping("/getQuotes")
	@HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
	public ResponseEntity<QuotesDetailsResponse> getQuotes(@RequestHeader(name = "Authorization") String token,@Valid @RequestParam Long businessValue, @RequestParam Long propertyValue,
			@RequestParam String propertyType) throws InvalidTokenException {
		log.info("Start getQuotes");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}
		QuotesDetailsResponse quotesDetailsResponse = policyService.getQuotes(businessValue, propertyValue,
				propertyType);
		log.debug("QuotesMaster: {}"+quotesDetailsResponse);
		log.info("End getQuotes");
		return ResponseEntity.ok(quotesDetailsResponse);
	}

	public MessageResponse sendPolicyErrorResponse() {
		return (new MessageResponse("(Policy Error Response!!"));

	}

	/*
	 *this method used to display the policy status based on consumer id and policy id.
	 */
	
	@GetMapping("/getPolices")
	public ResponseEntity<List<String>> getPolices(@RequestHeader(name = "Authorization") String token,@Valid @RequestParam Long consumerId, @RequestParam Long propertyId) throws InvalidTokenException {
		log.info("Start getPolices");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}
		List<String> policies = policyService.getAllPolicies(token, consumerId, propertyId);
		log.debug("policies: {}"+policies);
		log.info("End getPolices");
		return ResponseEntity.ok(policies);
	}

	
}
