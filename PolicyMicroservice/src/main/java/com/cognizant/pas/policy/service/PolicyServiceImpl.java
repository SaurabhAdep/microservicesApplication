package com.cognizant.pas.policy.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pas.policy.exception.ConsumerBusinessNotFoundException;
import com.cognizant.pas.policy.exception.ConsumerPolicyNotFoundException;
import com.cognizant.pas.policy.exception.PolicyNotFoundException;
import com.cognizant.pas.policy.models.ConsumerPolicy;
import com.cognizant.pas.policy.models.PolicyMaster;
import com.cognizant.pas.policy.models.Property;
import com.cognizant.pas.policy.payload.request.CreatePolicyRequest;
import com.cognizant.pas.policy.payload.request.IssuePolicyRequest;
import com.cognizant.pas.policy.payload.response.ConsumerBusinessResponse;
import com.cognizant.pas.policy.payload.response.MessageResponse;
import com.cognizant.pas.policy.payload.response.PolicyDetailsResponse;
import com.cognizant.pas.policy.payload.response.QuotesDetailsResponse;
import com.cognizant.pas.policy.repository.ConsumerPolicyRepository;
import com.cognizant.pas.policy.repository.PolicyMasterRepository;
import com.cognizant.pas.policy.restclients.ConsumerClient;
import com.cognizant.pas.policy.restclients.QuotesClient;

import lombok.extern.slf4j.Slf4j;

/**
 * Service Implementation for Policy Service
 */
@Service

public class PolicyServiceImpl implements PolicyService {

static Logger log = Logger.getLogger(PolicyServiceImpl.class);
	
	public PolicyServiceImpl() {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}
	
	@Autowired
	ConsumerPolicyRepository consumerPolicyRepository;

	@Autowired
	PolicyMasterRepository policyMasterRepository;

	@Autowired
	ConsumerClient consumerClient;

	@Autowired
	QuotesClient quotesClient;
	
	/*
	* @throws Exception  If an input or output 
	*                      exception occurred
	*/
	private static final String CNF="Sorry!!, No Consumer Found!!";
	private static final String PNF="Sorry!!, No Property Found!!";
	private static final String CDEBUG="consumerPolicy : {}";
	private static final String DNF = "Policy Not Found with these Details";

	
	/**
	 * service layer for get Quotes
	 * 
	 * @param businessValue, propertyValue and propertyType.
	 * @return Quotes Details Response value.
	 */
	@Override
	public QuotesDetailsResponse getQuotes(Long businessValue, Long propertyValue, String propertyType) {
		log.info("Start getQuotesService");
		String quote = quotesClient.quotesResponse(businessValue, propertyValue, propertyType);
		log.debug("quote : {}"+ quote);
		log.info("End getQuotesService");
		return (new QuotesDetailsResponse(quote));
	}

	/*
	 * remove 74 t0 77 line
	* line 81 -- ConsumerPolicy consumerPolicy = consumerPolicyRepository.findByConsumerId(consumerId);
	*/
	/**
	 * service layer for view Policy
	 * 
	 * @param consumerId and policyId.
	 * @return Policy Details Response value.
	 */
	@Override
	public PolicyDetailsResponse viewPolicy(Long consumerId, String policyId) throws PolicyNotFoundException,ConsumerPolicyNotFoundException {
		log.info("Start viewPolicyService");
		if(policyMasterRepository.findByPid(policyId) == null) {
			log.error(PNF);
			throw new PolicyNotFoundException(PNF);
		}	
		log.info("consumerId : {} "+consumerId);
		log.info("policyId : {}"+ policyId);
		ConsumerPolicy consumerPolicy = consumerPolicyRepository.findByConsumerIdAndPolicyId(consumerId, policyId);
		if(consumerPolicy == null) {
			log.error(DNF);
			throw new ConsumerPolicyNotFoundException(DNF);
		}		
		PolicyMaster policyMaster = policyMasterRepository.findByPid(policyId);
		log.debug("policyMaster : {}"+ policyMaster);
		log.debug(CDEBUG+ consumerPolicy);
		PolicyDetailsResponse policyDetailsResponse = new PolicyDetailsResponse(consumerId, policyMaster.getPid(),
				policyMaster.getpropertyType(), policyMaster.getconsumerType(), policyMaster.getassuredSum(),
				policyMaster.getTenure(), policyMaster.getbusinessValue(), policyMaster.getpropertyValue(),
				policyMaster.getbaseLocation(), policyMaster.getType(), consumerPolicy.getbusinessId(),
				consumerPolicy.getpaymentDetails(), consumerPolicy.getacceptanceStatus(),
				consumerPolicy.getpolicyStatus(), consumerPolicy.geteffectiveDate(), consumerPolicy.getcoveredSum(),
				consumerPolicy.getDuration(), consumerPolicy.getacceptedQuote());
		log.debug("policyDetailsResponse : {}"+ policyDetailsResponse);
		log.info("End viewPolicyService");
		return policyDetailsResponse;
	}

	/**
	 * service layer for create Policy
	 * 
	 * @param create Policy Request
	 * @return MessageResponse value.
	 */
	@Override
	public MessageResponse createPolicy(String token,CreatePolicyRequest createPolicyRequest) throws ConsumerBusinessNotFoundException {
		log.info("Start createPolicyService");
		ConsumerBusinessResponse consumerBusinessDetails = getConsumerBusiness(token,createPolicyRequest.getConsumerId());
		if(consumerBusinessDetails==null)
		{
			log.error("No Consumer Business Found !!");
			return new MessageResponse("No Consumer Business Found !!");
		}
		ConsumerPolicy consumerPolicyChecking = consumerPolicyRepository
				.findByConsumerIdAndPolicyId(createPolicyRequest.getConsumerId(),createPolicyRequest.getPoliceId());
		if(consumerPolicyChecking != null) {
			log.error("consumer details are already available");
			throw new ConsumerBusinessNotFoundException("Consumer Details are available with Policy Id : "+createPolicyRequest.getPoliceId());
		}
		log.debug("consumerBusinessDetails : {}"+ consumerBusinessDetails);
		ConsumerPolicy consumerPolicy = new ConsumerPolicy(consumerBusinessDetails.getConsumerID(),
				consumerBusinessDetails.getBusinessID(), "Initiated", createPolicyRequest.getAcceptedQuotes());
		consumerPolicy.setpolicyId(createPolicyRequest.getPoliceId());
		log.debug(CDEBUG+ consumerPolicy);
		ConsumerPolicy consumerPolicysave = consumerPolicyRepository.save(consumerPolicy);
		log.debug("consumerPolicysave : {}"+consumerPolicysave);
		log.info("End createPolicyService");
		return new MessageResponse("Policy Has been Created with Policy Id : " + consumerPolicysave.getpolicyId()
				+ " .Thank You Very Much!!");
	}
	
	/**
	 * service layer for issue Policy
	 * 
	 * @param issuePolicy Request
	 * @return Message Response value.
	 */

	@Override
	public MessageResponse issuePolicy(IssuePolicyRequest issuePolicyRequest)throws ConsumerPolicyNotFoundException,PolicyNotFoundException  {
		log.info("Start issuePolicyService");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		ConsumerPolicy consumerPolicy = consumerPolicyRepository
				.findByConsumerIdAndPolicyId(issuePolicyRequest.getconsumerId(),issuePolicyRequest.getpolicyId());
		log.debug(CDEBUG+ consumerPolicy);
		PolicyMaster policyMaster = policyMasterRepository.findByPid(issuePolicyRequest.getpolicyId());
		log.debug("policyMaster : {}"+ policyMaster);
		if(consumerPolicy == null) {
			log.error("Details are mismatched");
			throw new ConsumerPolicyNotFoundException("Details are mismatched");
		}
		if(consumerPolicy.getacceptanceStatus() != null || consumerPolicy.getpaymentDetails() != null){
			log.error("already saved");
			throw new ConsumerPolicyNotFoundException("Already Saved");
		}
		consumerPolicy.setpolicyId(issuePolicyRequest.getpolicyId());
		consumerPolicy.setpaymentDetails(issuePolicyRequest.getpaymentDetails());
		consumerPolicy.setacceptanceStatus(issuePolicyRequest.getacceptanceStatus());
		consumerPolicy.setpolicyStatus("Issued");
		consumerPolicy.seteffectiveDate(dtf.format(now));
		consumerPolicy.setDuration(policyMaster.getTenure());
		consumerPolicy.setcoveredSum(policyMaster.getassuredSum());
		ConsumerPolicy consumerPolicySave = consumerPolicyRepository.save(consumerPolicy);
		log.debug("consumerPolicySave : {}"+consumerPolicySave);
		log.info("End issuePolicyService");
		return new MessageResponse("Policy has Issued to PolicyConsumer Id : " + consumerPolicySave.getId()
				+ " .Thank You Very Much!!");
	}

	/**
	 * service layer for get Consumer Business
	 * 
	 * @param consumerid
	 * @return consumerBusinessDetails value.
	 */
	@Override
	public ConsumerBusinessResponse getConsumerBusiness(String token, Long consumerid)throws ConsumerBusinessNotFoundException {
		log.info("Start getConsumerBusiness");
		ConsumerBusinessResponse consumerBusinessDetails =  consumerClient.viewConsumerBusiness(token, consumerid);
		log.debug("consumerBusinessDetails : {}"+consumerBusinessDetails);
		log.info("End getConsumerBusiness");
		return consumerBusinessDetails;
	}
	
	@Override
	public List<String> getAllPolicies(String token, long consumerId, long propertyId) throws ConsumerBusinessNotFoundException {
		try {
			ConsumerBusinessResponse consumerBusinessResponse = consumerClient.viewConsumerBusiness(token, consumerId);
		
			Property property = consumerClient.viewConsumerProperty(token, consumerId, propertyId);
	
			List<PolicyMaster> policyMasterAll = policyMasterRepository.findByPropertyTypeAndConsumerTypeAndPropertyValueAndBusinessValueAndType(
					property.getPropertyType(), property.getBuildingType(), property.getPropertyValue(), consumerBusinessResponse.getBusinessValue(), property.getInsuranceType());
			List<String> polices = policyMasterAll.stream().map(e->e.getPid()).collect(Collectors.toList());
			return(polices);
		}
		catch(Exception e) {
			log.debug("{}"+e.getMessage());
			if(e.getMessage().contains(CNF)) {
				throw new ConsumerBusinessNotFoundException(CNF);
			}
			throw new ConsumerBusinessNotFoundException(PNF);
		}		
	}

	
	
	
	
	
	
	
	
}
