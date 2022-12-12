package com.cognizant.pas.policy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.pas.policy.exception.ConsumerBusinessNotFoundException;
import com.cognizant.pas.policy.payload.request.CreatePolicyRequest;
import com.cognizant.pas.policy.payload.request.IssuePolicyRequest;
import com.cognizant.pas.policy.payload.response.ConsumerBusinessResponse;
import com.cognizant.pas.policy.payload.response.MessageResponse;
import com.cognizant.pas.policy.payload.response.PolicyDetailsResponse;
import com.cognizant.pas.policy.payload.response.QuotesDetailsResponse;

/**
 * Policy Service Interface for the Policy Service functionality
 */
@Service
public interface PolicyService {

	QuotesDetailsResponse getQuotes(Long businessValue, Long propertyValue, String propertyType);

	PolicyDetailsResponse viewPolicy(Long consumerId, String policyId);

	MessageResponse issuePolicy(IssuePolicyRequest issuePolicyRequest);

	MessageResponse createPolicy(String token,CreatePolicyRequest createPolicyRequest);
	
	ConsumerBusinessResponse getConsumerBusiness(String token,Long consumerId);
	
	List<String> getAllPolicies(String token, long consumerId, long propertyId) throws ConsumerBusinessNotFoundException;
	
}
