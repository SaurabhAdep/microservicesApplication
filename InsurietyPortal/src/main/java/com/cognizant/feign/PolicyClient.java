package com.cognizant.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.CreatePolicyRequest;
import com.cognizant.model.IssuePolicyRequest;
import com.cognizant.model.PolicyDetailsResponse;
import com.cognizant.payload.MessageResponse;
import com.cognizant.payload.QuotesDetailsResponse;

import feign.Headers;

@Headers("Content-Type: application/json")
//13.126.73.169
@FeignClient(name = "policy-service-client", url = "http://localhost:8002/policy-api")
public interface PolicyClient {
	@PostMapping("/createPolicy")
	public MessageResponse createPolicy(
			@RequestHeader(name = "Authorization") String token,@Valid @RequestBody CreatePolicyRequest createPolicyRequest);
	
	@GetMapping("/viewPolicy")
	public PolicyDetailsResponse viewPolicy(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestParam Long consumerid, @RequestParam String policyid);

	@PostMapping("/issuePolicy")
	public MessageResponse issuePolicy(
			@RequestHeader(name = "Authorization") String token,@Valid @RequestBody IssuePolicyRequest issuePolicyRequest);
	
	@GetMapping("/getQuotes")
	public QuotesDetailsResponse getQuotes(@RequestHeader(name = "Authorization") String token,@Valid @RequestParam Long businessValue, @RequestParam Long propertyValue,
			@RequestParam String propertyType);
	
	@GetMapping("/getPolices")
	public List<String> getPolices(@RequestHeader(name = "Authorization") String token,@Valid @RequestParam Long consumerId, @RequestParam Long propertyId);

}

