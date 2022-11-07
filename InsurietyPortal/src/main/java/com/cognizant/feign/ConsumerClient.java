package com.cognizant.feign;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.Property;
import com.cognizant.payload.BusinessPropertyRequest;
import com.cognizant.payload.ConsumerBusinessRequest;
import com.cognizant.payload.ConsumerBusinessResponse;

import feign.Headers;

@Headers("Content-Type: application/json")
@FeignClient(name = "consumer-service", url = "http://localhost:8001")
public interface ConsumerClient {
	
	@GetMapping("/consumer-api/viewConsumerBusiness")
	public ConsumerBusinessResponse viewConsumerBusiness(@RequestHeader(name = "Authorization") String token,@Valid @RequestParam long consumerId);
	
	@PostMapping("/consumer-api/createConsumerBusiness")
	public String createConsumerBusiness(@RequestHeader(name = "Authorization") String token,@Valid @RequestBody ConsumerBusinessRequest consumer);
	
	@PutMapping("/consumer-api/updateConsumerBusiness")
	public String updateConsumerBusiness(@RequestHeader(name = "Authorization") String token,@Valid @RequestBody ConsumerBusinessRequest consumer);
	
	@PostMapping("/consumer-api/createBusinessProperty")
	public String createBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody BusinessPropertyRequest BusinessProperty);

	@PutMapping("/consumer-api/updateBusinessProperty")
	public String updateBusinessProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody BusinessPropertyRequest BusinessProperty);

	@GetMapping("/consumer-api/viewConsumerProperty")
	public Property viewConsumerProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestParam Long consumerId, @RequestParam Long propertyId);
	
	@GetMapping("/consumer-api/getAllProperties")
	public List<Property> viewConsumerProperty(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestParam Long consumerId);
}
