package com.cognizant.service;

import com.cognizant.exception.BusinessNotFoundException;
import com.cognizant.exception.ConsumerNotFoundException;
import com.cognizant.model.Business;
import com.cognizant.model.Consumer;
import com.cognizant.payload.ConsumerBusinessRequest;
import com.cognizant.payload.ConsumerBusinessResponse;


/**
 * Service interface for ConsumerBusiness
 */

public interface ConsumerBusinessService {
	
	public String createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest) throws ConsumerNotFoundException;
	
	public Long calBusinessValue(Long businessTurnover, Long capitalInvested);
	
	public ConsumerBusinessResponse viewConsumerBusiness(long consumerId) throws ConsumerNotFoundException, BusinessNotFoundException;
	
	public Boolean checkBusinessEligibility(Business business);
	
	public String updateConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest)  throws ConsumerNotFoundException;
	
	public ConsumerBusinessResponse changeDetails(Consumer consumer);

	public Consumer changeDetailsUsingConsumerBusinessDetails(ConsumerBusinessRequest consumerBusinessRequest);
		

}
