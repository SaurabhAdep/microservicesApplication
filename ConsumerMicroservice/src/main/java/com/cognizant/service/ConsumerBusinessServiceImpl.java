package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.BusinessNotFoundException;
import com.cognizant.exception.ConsumerNotFoundException;
import com.cognizant.model.Business;
import com.cognizant.model.BusinessMaster;
import com.cognizant.model.Consumer;
import com.cognizant.model.Property;
import com.cognizant.payload.ConsumerBusinessRequest;
import com.cognizant.payload.ConsumerBusinessResponse;
import com.cognizant.repository.BusinessMasterRepository;
import com.cognizant.repository.BusinessRepository;
import com.cognizant.repository.ConsumerRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service implementation class for ConsumerBussiness
 */

@Service
public class ConsumerBusinessServiceImpl implements ConsumerBusinessService {

static Logger log = Logger.getLogger(ConsumerBusinessServiceImpl.class);
	
	public ConsumerBusinessServiceImpl() {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}
	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private BusinessMasterRepository businessMasterRepository;
	
	private static final String CNF="Sorry!!, No Consumer Found!!";
	
	private static final String CDEBUG="consumer : {}";
	private static final String BDEBUG="business : {}";
	
	/**
	 * Method For Creating Business Property
	 * @throws ConsumerNotFoundException 
	 */
	@Override
	public String createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest) throws ConsumerNotFoundException {
		log.info("started CreateConsumerBusiness Method");

		Consumer consumer = changeDetailsUsingConsumerBusinessDetails(consumerBusinessRequest);
		
		if(consumerRepository.existsByPanDetails(consumer.getPanDetails())) {
			log.error("consumer already Exists");
			throw new ConsumerNotFoundException("consumer already Exists");
		}

		Business business = consumer.getBusiness();

		Long businessValue = calBusinessValue(business.getBusinessTurnover(), business.getCapitalInvested());

		business.setBusinessValue(businessValue);

		log.debug("businessValue : {}"+businessValue);

		log.debug(BDEBUG+ business);

		businessRepository.saveAndFlush(business);


		consumer.setBusiness(business);

		Consumer consumerSave = consumerRepository.saveAndFlush(consumer);

		log.info("ended CreateConsumerBusiness Method");
		return ("SuccessFully Created Consumer with Consumer ID :" + consumerSave.getId() + " and Business ID :"
				+ business.getId() + " . Thank you!!");

	}

	/**
	 * Method For viewing Business Property
	 */
	@Override
	public ConsumerBusinessResponse viewConsumerBusiness(long consumerId)
			throws ConsumerNotFoundException, BusinessNotFoundException {
		log.info("started viewConsumerBusiness Method");

		log.info("" + consumerId);
		if (!consumerRepository.existsById(consumerId)) {
			log.error(CNF);
			throw new ConsumerNotFoundException(CNF);
		}

		Consumer consumer = consumerRepository.findById(consumerId).orElse(new Consumer());

		log.debug(CDEBUG+ consumer);

		if (consumer.getBusiness() == null) {
			log.error("Sorry!!, No Business Found!!");
			throw new BusinessNotFoundException("Sorry!!, No Business Found!!");
		}
		Business business = consumer.getBusiness();

		log.debug(BDEBUG+ business);

		ConsumerBusinessResponse consumerBusinessDetails = changeDetails(consumer);

		log.info("ended viewConsumerBusiness Method");
		return (consumerBusinessDetails);
	}

	/**
	 * Method For updating Business Property
	 */
	@Override
	public String updateConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest)
			throws ConsumerNotFoundException {
		log.info("started getConsumerBusiness Method");

		Consumer consumer = changeDetailsUsingConsumerBusinessDetails(consumerBusinessRequest);
		Optional<?> value=consumerRepository.findById(consumer.getId());
		if (!value.isPresent()) {
			log.error(CNF);
			throw new ConsumerNotFoundException(CNF);
		}

		Business businessDetails = consumer.getBusiness();

		businessDetails.setBusinessValue(
				calBusinessValue(businessDetails.getBusinessTurnover(), businessDetails.getCapitalInvested()));

		Business business = businessRepository.save(businessDetails);

		log.debug(BDEBUG+business);

		Consumer consumerSave = consumerRepository.save(consumer);

		log.debug(CDEBUG+ consumerSave);

		log.info("ended getConsumerBusiness Method");
		return ("Successfully Updated Consumer with Consumer ID: " + consumerSave.getId() + " and Business ID: "
				+ business.getId() + " . Thank you!");
	}

	/**
	 * This method calculates the business value based on businessTurnOver and
	 * CaptialInvested
	 */
	@Override
	public Long calBusinessValue(Long businessTurnover, Long capitalInvested) {
		log.info("Started CalBusinessValue Method");
		if (businessTurnover == 0 || capitalInvested == 0 || (businessTurnover.equals(capitalInvested))) {
			log.error("NullPointerException in CalBusinessValue");
			throw new NullPointerException("NullPointerException in CalBusinessValue");
		}

		Double xRatio = (double) (businessTurnover / (double)capitalInvested);
		log.debug("X_ratio: {}"+ xRatio);
		Double rangeMin = 0D;
		Double rangeMax = 10D;
		Double xMax = (double) businessTurnover;
		Double xMin = (double) capitalInvested;
		Double rangeDiff = (double) (rangeMax - rangeMin);
		log.debug("range_diff : {}"+ rangeDiff);
		Double sat = ((xRatio - xMin) / (xMax - xMin));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}"+ sat);
		Double businessvalue = (rangeDiff * sat);
		log.debug("BusinessValue: {}"+ businessvalue);
		log.info("Ended CalBusinessValue Method");
		return (long) Math.abs(Math.round(businessvalue));
	}

	/**
	 * This method checks if the Business is eligible or not and returns a boolean
	 * value
	 */
	@Override
	public Boolean checkBusinessEligibility(Business business){
		Boolean check = false;
		log.info("Start checkBusinessEligibility");

		BusinessMaster businessMaster = businessMasterRepository
				.findByBusinessCategoryAndBusinessType(business.getBusinessCategory(), business.getBusinessType());
		if (businessMaster == null) {
			return check;
		}
		log.debug("Business Master {}"+ businessMaster);
		if (businessMaster.getTotalEmployees() <= business.getTotalEmployees()
				|| businessMaster.getBusinessAge() <= business.getBusinessAge()) {
			check = true;
			log.debug("Vaule of Check {}"+check);
		}
		log.debug("Vaule of Check {}"+ check);
		log.info("End checkBusinessEligibility");
		return check;
	}

	/**
	 * This method used to convert the consumer class to ConsumerBusinessResponse
	 * class
	 */
	@Override
	public ConsumerBusinessResponse changeDetails(Consumer consumer) {
		log.info("start ConsumerBusinessDetails");
		Business business = consumer.getBusiness();

		ConsumerBusinessResponse consumerBusinessDetails = new ConsumerBusinessResponse(consumer.getId(),
				consumer.getFirstName(), consumer.getLastName(), consumer.getDob(), consumer.getBusinessName(),
				consumer.getPanDetails(), consumer.getEmail(), consumer.getPhone(), consumer.getWebsite(),
				consumer.getBusinessOverview(), consumer.getValidity(), consumer.getAgentName(), consumer.getAgentID(),
				business.getId(), business.getBusinessCategory(), business.getBusinessType(),
				business.getBusinessTurnover(), business.getCapitalInvested(), business.getTotalEmployees(),
				business.getBusinessValue(), business.getBusinessAge());
		log.info("End ConsumerBusinessDetails");
		return (consumerBusinessDetails);

	}

	/**
	 * This method used to convert the ConsumerBusinessRequest class to Consumer
	 * class
	 */
	@Override
	public Consumer changeDetailsUsingConsumerBusinessDetails(ConsumerBusinessRequest consumerBusinessRequest) {
		log.info("start changeDetailsUsingConsumerBusinessDetails");

		Business business = new Business((long) 1, consumerBusinessRequest.getBusinessCategory(),
				consumerBusinessRequest.getBusinessType(), (long) consumerBusinessRequest.getBusinessTurnover(),
				(long) consumerBusinessRequest.getCapitalInvested(), (long) consumerBusinessRequest.getTotalEmployees(),
				(long) 0, (long) consumerBusinessRequest.getBusinessAge());

		log.debug(BDEBUG+ business);

		Consumer consumer = new Consumer(consumerBusinessRequest.getConsumerId(),
				consumerBusinessRequest.getFirstName(), consumerBusinessRequest.getLastName(),
				consumerBusinessRequest.getDob(), consumerBusinessRequest.getBusinessName(),
				consumerBusinessRequest.getPanDetails(), consumerBusinessRequest.getEmail(),
				consumerBusinessRequest.getPhone(), consumerBusinessRequest.getWebsite(),
				consumerBusinessRequest.getBusinessOverview(), consumerBusinessRequest.getValidity(),
				consumerBusinessRequest.getAgentName(), (long) consumerBusinessRequest.getAgentID(), business, null);

		log.debug(CDEBUG+consumer);

		log.info("End changeDetailsUsingConsumerBusinessDetails");
		return (consumer);
	}

	

}
