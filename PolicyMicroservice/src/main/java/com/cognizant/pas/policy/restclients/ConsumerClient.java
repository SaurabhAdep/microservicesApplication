package com.cognizant.pas.policy.restclients;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.pas.policy.models.Property;
import com.cognizant.pas.policy.payload.response.ConsumerBusinessResponse;

import feign.Headers;


/**
 * Consumer Client used for connection with Consumer MicroService
 */
@Headers("Content-Type: application/json")
@FeignClient(name = "consumer-service", url = "http://localhost:8001")
//@FeignClient(name = "consumer-service", url = "65.2.69.127:8086")
public interface ConsumerClient {
	
	@GetMapping("/consumer-api/viewConsumerBusiness")
	public ConsumerBusinessResponse viewConsumerBusiness(@RequestHeader(name = "Authorization") String token,@Valid @RequestParam Long consumerId);
	
	@GetMapping("/consumer-api/viewConsumerProperty")
	public Property viewConsumerProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestParam Long consumerId, @RequestParam Long propertyId);
	
}
