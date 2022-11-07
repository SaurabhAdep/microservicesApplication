package com.cognizant.controller;

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
import com.cognizant.exception.InvalidTokenException;
import com.cognizant.feign.AuthClient;
import com.cognizant.payload.ConsumerBusinessRequest;
import com.cognizant.payload.ConsumerBusinessResponse;
import com.cognizant.service.ConsumerBusinessServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Controller class for ConsumerBusiness
 */

@RestController
public class ConsumerBusinessController {

static Logger log = Logger.getLogger(ConsumerBusinessController.class);
	
	public ConsumerBusinessController() {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}
	@Autowired
	private ConsumerBusinessServiceImpl consumerBusinessService;

	@Autowired
	private AuthClient authClient;
	
	private static final String IT="Invalid token";
	
	private static final String CDEBUG="consumer : {}";
	/**
	 * @param token for authenticating access 
	 * Rest End Point for creating consumer Business
	 * @throws ConsumerNotFoundException 
	 */
	@PostMapping("/createConsumerBusiness")
	@Operation(summary = "This end point will used to create the consumer bussiness Details")
	public ResponseEntity<String> createConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody ConsumerBusinessRequest consumer) throws InvalidTokenException, ConsumerNotFoundException{
		log.info("Start createConsumerBusiness");

		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}

		log.debug(CDEBUG+ consumer);
		String messageResponse = consumerBusinessService.createConsumerBusiness(consumer);
		log.debug("ConsumerBusiness Status: {}"+ messageResponse);
		log.info("End createConsumerBusiness");
		return (new ResponseEntity<>(messageResponse, HttpStatus.CREATED));
	}
	
	/**
	 * @param token for authenticating access 
	 * Rest End Point for viewing consumer Business
	 * @throws InvalidTokenException 
	 */
	@GetMapping("/viewConsumerBusiness")
	@Operation(summary = "This end point will used to return the consumer bussiness Details")
	public ResponseEntity<ConsumerBusinessResponse> viewConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@RequestParam Long consumerId) throws ConsumerNotFoundException, BusinessNotFoundException, InvalidTokenException {
		log.info("Start viewConsumerBusiness");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}
		ConsumerBusinessResponse consumer = consumerBusinessService.viewConsumerBusiness(consumerId);

		log.debug("ConsumerBusiness Details: {}"+ consumer);

		log.info("End viewConsumerBusiness");

		return(new ResponseEntity<>(consumer, HttpStatus.OK));

	}

	/**
	 * @param token for authenticating access 
	 * Rest End Point for updating consumer Business
	 * @throws InvalidTokenException 
	 */
	@PutMapping("/updateConsumerBusiness")
	@Operation(summary = "This end point will used to Update the consumer bussiness Details")
	public ResponseEntity<String> updateConsumerBusiness(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody ConsumerBusinessRequest consumer) throws ConsumerNotFoundException, InvalidTokenException {
		log.info("started updateConsumerBusiness method");
		if (token == null || !authClient.validate(token)) {
			log.error(IT);
			throw new InvalidTokenException(IT);
		}
		log.debug(CDEBUG+ consumer);

		String messageResponse = consumerBusinessService.updateConsumerBusiness(consumer);

		log.info("ended updateConsumerBusiness method");
		return (new ResponseEntity<>(messageResponse, HttpStatus.OK));
	}
	
	
	
	

}
