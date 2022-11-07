package com.cognizant.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.BusinessNotFoundException;
import com.cognizant.exception.ConsumerNotFoundException;
import com.cognizant.exception.ConsumerPropertyNotFound;
import com.cognizant.exception.InvalidTokenException;
import com.cognizant.feign.AuthClient;
import com.cognizant.model.Property;
import com.cognizant.payload.BusinessPropertyRequest;
import com.cognizant.service.ConsumerPropertyService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for ConsumerProperty
 */

@RestController
public class ConsumerPropertyController {

	static Logger log = Logger.getLogger(ConsumerPropertyController.class);

	public ConsumerPropertyController() {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}

	@Autowired
	private ConsumerPropertyService consumerPropertyService;

	@Autowired
	private AuthClient authClient;

	private static final String IT = "Invalid token";

	private static final String CDEBUG = "consumer : {}";

	/**
	 * @param token for authenticating access
	 * 
	 *              End Point for creating a business property
	 * @throws ConsumerNotFoundException
	 */
	@PostMapping("/createBusinessProperty")
	@Operation(summary = "This end point will used to create the consumer property Details")
	public ResponseEntity<String> createBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody BusinessPropertyRequest businessProperty) throws ConsumerNotFoundException {
		log.info("Start createConsumerProperty");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			return new ResponseEntity<>(IT, HttpStatus.FORBIDDEN);
		}
		log.debug(CDEBUG+ businessProperty);
		String messageResponse = consumerPropertyService.createBusinessProperty(businessProperty);
		log.debug("ConsumerProperty Status: {}"+ messageResponse);
		log.info("End createConsumerProperty");
		return (new ResponseEntity<>(messageResponse, HttpStatus.CREATED));
	}

	/**
	 *
	 * @param token for authenticating access End Point for updating business
	 *              property
	 * @throws ConsumerPropertyNotFound
	 * @throws ConsumerNotFoundException
	 */
	@PutMapping("/updateBusinessProperty")
	@Operation(summary = "This end point will used to Update the consumer property Details")
	public ResponseEntity<String> updateBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody BusinessPropertyRequest businessProperty)
			throws ConsumerNotFoundException, ConsumerPropertyNotFound {

		log.info("Start updateBusinessProperty");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			return new ResponseEntity<>(IT, HttpStatus.FORBIDDEN);
		}
		log.debug(CDEBUG+ businessProperty);

		String messageResponse = consumerPropertyService.updateBusinessProperty(businessProperty);

		log.info("End updateBusinessProperty");
		return (new ResponseEntity<>(messageResponse, HttpStatus.OK));

	}

	/**
	 * @param token for authenticating access Rest End Point for viewing property
	 */
	@GetMapping("/viewConsumerProperty")
	@Operation(summary = "This end point will used to return the consumer property Details")
	public ResponseEntity<Object> viewConsumerProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestParam Long consumerId, @RequestParam Long propertyId)
			throws ConsumerPropertyNotFound, BusinessNotFoundException, ConsumerNotFoundException {
		log.info("Start viewConsumerProperty");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			return new ResponseEntity<>(IT, HttpStatus.FORBIDDEN);
		}
		Property property = consumerPropertyService.viewConsumerProperty(consumerId, propertyId);
		log.debug("BusinessProperty Details: {}"+ property);
		log.info("End viewConsumerProperty");
		return ResponseEntity.status(HttpStatus.OK).body(property);
	}

	@GetMapping("/getAllProperties")

	@Operation(summary = "This end point will used to return the consumer property Details")
	public ResponseEntity<List<Property>> viewConsumerProperty(@RequestHeader(name = "Authorization") String token,

			@Valid @RequestParam Long consumerId)
			throws ConsumerPropertyNotFound, ConsumerNotFoundException, InvalidTokenException {
		log.info("Start viewConsumerProperty");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}
		List<Property> property = consumerPropertyService.getAllProperties(consumerId);
		log.debug("BusinessProperty Details: {}"+property);
		log.info("End viewConsumerProperty");
		return ResponseEntity.status(HttpStatus.OK).body(property);
	}

}
