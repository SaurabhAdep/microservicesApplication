package com.cognizant.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.feign.ConsumerClient;
import com.cognizant.feign.PolicyClient;
import com.cognizant.model.Property;
import com.cognizant.payload.ConsumerBusinessRequest;
import com.cognizant.payload.ConsumerBusinessResponse;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ConsumerBusinessService {

	@Autowired
	private ConsumerClient consumerClient;
	
	@Autowired
	private PolicyClient PolicyClient; 
	
	public ConsumerBusinessResponse viewConsumerBusiness(String token,long consumerId) {
		log.info("start viewConsumerBusiness");
		ConsumerBusinessResponse consumerBusinessResponse = consumerClient.viewConsumerBusiness(token, consumerId);
		log.debug("consumerBusinessReponse : {}",consumerBusinessResponse);
		log.info("end viewConsumerBusiness");
		return(consumerBusinessResponse);
	}
	
	public String createConsumerBusiness(String token,ConsumerBusinessRequest consumerBusinessRequest) {
		log.info("start createConsumerBusiness");
		String response = consumerClient.createConsumerBusiness(token, consumerBusinessRequest);
		log.debug("consumerBusinessReponse : {}",response);
		log.info("end createConsumerBusiness");
		return(response);
	}
	
	public ConsumerBusinessRequest getDetailsForUpdate(String token,long consumerId) {
		log.info("start ConsumerBusinessRequest");
		ConsumerBusinessResponse consumerBusinessResponse = viewConsumerBusiness(token, consumerId);
		ConsumerBusinessRequest consumerBusinessRequest = new ConsumerBusinessRequest(consumerBusinessResponse.getConsumerID(), consumerBusinessResponse.getFirstName(), consumerBusinessResponse.getLastName(), consumerBusinessResponse.getDob(), consumerBusinessResponse.getBusinessName(), consumerBusinessResponse.getPanDetails(), consumerBusinessResponse.getEmail(), consumerBusinessResponse.getPhone(), consumerBusinessResponse.getWebsite(), consumerBusinessResponse.getBusinessOverview(), consumerBusinessResponse.getValidity(), consumerBusinessResponse.getAgentName(), consumerBusinessResponse.getAgentID(), consumerBusinessResponse.getBusinessCategory(), consumerBusinessResponse.getBusinessType(), consumerBusinessResponse.getBusinessTurnover(), consumerBusinessResponse.getCapitalInvested(), consumerBusinessResponse.getTotalEmployees(), consumerBusinessResponse.getBusinessAge());
		log.info("end ConsumerBusinessRequest");
		return(consumerBusinessRequest);
	}

	public String updateConsumerBusiness(String token,ConsumerBusinessRequest consumerBusinessRequest) {
		log.info("start updateConsumerBusiness");
		String response = consumerClient.updateConsumerBusiness(token, consumerBusinessRequest);
		log.debug("consumerBusinessReponse : {}",response);
		log.info("end updateConsumerBusiness");
		return(response);
	}
	
	
	public String getQuote(String token,String policyId,long consumerId,long propertyId) {
		log.info("start getQuote");
		long businessValue = consumerClient.viewConsumerBusiness(token, consumerId).getBusinessValue();
		Property propertyList = consumerClient.viewConsumerProperty(token, consumerId, propertyId);
		long propertyValue = propertyList.getPropertyValue();
		log.debug("{}",businessValue);
		log.debug("{}",propertyValue);
		log.debug("{}", propertyList.getBuildingType());
		String quote = PolicyClient.getQuotes(token, businessValue, propertyValue, propertyList.getPropertyType()).getQuotes();
		return(quote);
	}
	
	
}
