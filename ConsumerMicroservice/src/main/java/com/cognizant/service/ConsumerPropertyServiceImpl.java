package com.cognizant.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.BusinessNotFoundException;
import com.cognizant.exception.ConsumerNotFoundException;
import com.cognizant.exception.ConsumerPropertyNotFound;
import com.cognizant.model.Consumer;
import com.cognizant.model.Property;
import com.cognizant.model.PropertyMaster;
import com.cognizant.payload.BusinessPropertyRequest;
import com.cognizant.repository.ConsumerRepository;
import com.cognizant.repository.PropertyMasterRepository;
import com.cognizant.repository.PropertyRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service implementation class for ConsumerProperty
 */

@Service
@Slf4j
public class ConsumerPropertyServiceImpl implements ConsumerPropertyService {

	static Logger log = Logger.getLogger(ConsumerBusinessServiceImpl.class);

	public ConsumerPropertyServiceImpl() {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}

	@Autowired
	private PropertyRepository propertyRepository;
	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	PropertyMasterRepository propertyMasterRepository;

	private static final String CNF = "Sorry!!, No Consumer Found!!";
	private static final String PNF = "Sorry!!, No Property Found!!";

	private static final String CDEBUG = "consumer : {}";
	private static final String PDEBUG = "property : {}";

	/**
	 * Method For Creating Business Property
	 * 
	 * @throws ConsumerNotFoundException
	 */
	@Override
	public String createBusinessProperty(BusinessPropertyRequest businessProperty) throws ConsumerNotFoundException {
		log.info("Start createConsumerBusinessService");
		if (!consumerRepository.existsById(businessProperty.getConsumerId())) {
			log.error(CNF);
			throw new ConsumerNotFoundException(CNF);
		}
		Consumer consumer = consumerRepository.findById(businessProperty.getConsumerId()).get();
		Property property = new Property(null, businessProperty.getInsuranceType(), businessProperty.getPropertyType(),
				businessProperty.getBuildingSqft(), businessProperty.getBuildingType(),
				businessProperty.getBuildingStoreys(), businessProperty.getBuildingAge(), null,
				businessProperty.getCostOfTheAsset(), businessProperty.getSalvageValue(),
				businessProperty.getUsefulLifeOfTheAsset());

		Long propertyValue = calPropertyValue(property.getCostOfTheAsset(), property.getSalvageValue(),
				property.getUsefulLifeOfTheAsset());

		property.setPropertyValue(propertyValue);
		log.debug("propertyValue : {}"+ propertyValue);
		log.debug(PDEBUG+ property);
		consumer.getProperty().add(property);

		propertyRepository.saveAndFlush(property);
		consumerRepository.saveAndFlush(consumer);
		log.debug("propertysave : {}"+ property);
		log.info("End createConsumerPropertyService");
		return "SuccessFully Created Business Property with Property Id: " + property.getId() + " . Thank you!!";
	}

	/**
	 * Method For Viewing Consumer Property
	 */
	@Override
	public Property viewConsumerProperty(Long consumerId, Long propertyId)
			throws ConsumerNotFoundException, BusinessNotFoundException, ConsumerPropertyNotFound {
		log.info("started viewConsumerProperty Method");

		if (!consumerRepository.existsById(consumerId)) {
			log.error(CNF);
			throw new ConsumerNotFoundException(CNF);
		}
		Consumer consumer = consumerRepository.findById(consumerId).orElse(new Consumer());
		log.debug(CDEBUG+ consumer);
		if (consumer.getProperty() == null) {
			log.error(PNF);
			throw new ConsumerPropertyNotFound(PNF);
		}
		Property property = consumer.getProperty().stream().filter(e -> e.getId().equals(propertyId)).findFirst()
				.orElse(new Property());

		log.debug(PDEBUG+ property);
		log.info("End viewConsumerPropertyService");
		return property;
	}

	/**
	 * Method For Updating Business Property
	 * 
	 * @throws ConsumerNotFoundException
	 * @throws ConsumerPropertyNotFound
	 */
	@Override
	public String updateBusinessProperty(BusinessPropertyRequest businessProperty)
			throws ConsumerNotFoundException, ConsumerPropertyNotFound {
		log.info("Start updateBusinessPropertyService");
		if (!consumerRepository.existsById(businessProperty.getConsumerId())) {
			log.error(CNF);
			throw new ConsumerNotFoundException(CNF);
		}
		Consumer consumer = consumerRepository.findById(businessProperty.getConsumerId()).orElse(new Consumer());

		if (consumer.getProperty() == null) {
			log.error(PNF);
			throw new ConsumerPropertyNotFound(PNF);
		}
		Property property = new Property(businessProperty.getId(), businessProperty.getInsuranceType(),
				businessProperty.getPropertyType(), businessProperty.getBuildingSqft(),
				businessProperty.getBuildingType(), businessProperty.getBuildingStoreys(),
				businessProperty.getBuildingAge(), null, businessProperty.getCostOfTheAsset(),
				businessProperty.getSalvageValue(), businessProperty.getUsefulLifeOfTheAsset());
		Long propertyValue = calPropertyValue(property.getCostOfTheAsset(), property.getSalvageValue(),
				property.getUsefulLifeOfTheAsset());

		property.setPropertyValue(propertyValue);
		log.debug(PDEBUG+ property);

		consumer.getProperty().remove(propertyRepository.findById(property.getId()).orElse(new Property()));
		consumer.getProperty().add(property);
		Consumer consumerSave = consumerRepository.save(consumer);
		propertyRepository.save(property);
		log.debug("consumersave  : {}"+ consumerSave);
		log.info("End updateBusinessPropertyService");
		return "SuccessFully Updated Business Property with Property Id :" + property.getId() + " . Thank you!";
	}

	/**
	 * This method calculates the property value based on some attributes of the
	 * property class
	 */
	@Override
	public Long calPropertyValue(Long costOfTheAsset, Long salvageValue, Long usefulLifeOfTheAsset) {
		log.info("Start calPropertyValue");
		if (usefulLifeOfTheAsset == 0 || salvageValue == 0 || costOfTheAsset == 0
				|| (costOfTheAsset.equals(salvageValue))) {
			log.error("NullPointerException in calPropertyValue");
			throw new NullPointerException("NullPointerException in calPropertyValue");
		}
		Double xRatio = (double) ((costOfTheAsset - salvageValue) / (double) usefulLifeOfTheAsset);
		log.debug("x_ratio : {}"+ xRatio);
		Double rangeMin = 0D;
		Double rangeMax = 10D;
		Double xMax = (double) (costOfTheAsset / (double) usefulLifeOfTheAsset);
		log.debug("x_max : {}"+ xMax);
		Double xMin = (double) (salvageValue / (double) usefulLifeOfTheAsset);
		log.debug("x_min : {}"+ xMin);
		Double rangeDiff = (rangeMax - rangeMin);
		log.debug("range_diff : {}"+rangeDiff);
		Double sat = ((xRatio - xMin) / (xMax - xMin));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}"+ sat);
		Double propertyvalue = rangeDiff * sat;
		log.debug("propertyvalue  : {}"+ propertyvalue);
		log.info("End calPropertyValue");
		return (long) Math.abs(Math.round(propertyvalue));
	}

	/**
	 * This method checks if the property is eligible or not and returns a boolean
	 * value
	 */
	@Override
	public Boolean checkPropertyEligibility(String propertyType, String insuranceType, String buildingType,
			Long buildingAge) throws ConsumerPropertyNotFound {
		log.info("Start checkPropertyEligibility");
		Boolean check = false;
		PropertyMaster propertyMaster = propertyMasterRepository
				.findByPropertyTypeAndInsuranceTypeAndBuildingType(propertyType, insuranceType, buildingType);
		if (propertyMaster == null) {
			return check;
		}
		log.debug("propertyMaster {}"+ propertyMaster);
		if (propertyMaster.getBuildingAge() <= buildingAge) {
			check = true;
			log.debug("Vaule of Check {}"+ check);
		}
		log.debug("Vaule of Check {}"+ check);
		log.info("End checkPropertyEligibility");
		return check;
	}

	@Override
	public List<Property> getAllProperties(long consumerId) throws ConsumerNotFoundException, ConsumerPropertyNotFound {
		log.info("started viewConsumerProperty Method");

		if (!consumerRepository.existsById(consumerId)) {
			log.error(CNF);
			throw new ConsumerNotFoundException(CNF);
		}

		Consumer consumer = consumerRepository.findById(consumerId).orElse(new Consumer());
		log.debug(CDEBUG+ consumer);
		if (consumer.getProperty() == null) {
			log.error(PNF);
			throw new ConsumerPropertyNotFound(PNF);
		}
		List<Property> propertyList = consumer.getProperty();
		log.debug(PDEBUG+ propertyList);
		log.info("End viewConsumerPropertyService");
		return (propertyList);
	}

}
