package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.exception.BusinessNotFoundException;
import com.cognizant.exception.ConsumerNotFoundException;
import com.cognizant.exception.ConsumerPropertyNotFound;
import com.cognizant.model.Property;
import com.cognizant.payload.BusinessPropertyRequest;

/**
 * Service interface for ConsumerProperty
 */

@Service
public interface ConsumerPropertyService {

	public String createBusinessProperty(BusinessPropertyRequest businessProperty) throws ConsumerNotFoundException;
	public Property viewConsumerProperty(Long consumerId, Long propertyId) throws ConsumerNotFoundException,BusinessNotFoundException,ConsumerPropertyNotFound;
	Boolean checkPropertyEligibility(String propertyType, String insuranceType, String buildingType, Long buildingAge) throws ConsumerPropertyNotFound;

	String updateBusinessProperty(BusinessPropertyRequest businessProperty) throws ConsumerNotFoundException, ConsumerPropertyNotFound;
	Long calPropertyValue(Long costOfTheAsset, Long salvageValue, Long usefulLifeOfTheAsset);
	public List<Property> getAllProperties(long consumerId) throws ConsumerNotFoundException, ConsumerPropertyNotFound;
	
	
}
