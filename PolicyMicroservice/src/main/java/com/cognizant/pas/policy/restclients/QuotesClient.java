package com.cognizant.pas.policy.restclients;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Headers;

/**
 * Quotes Client used for connection with Quotes MicroService
 */
@Headers("Content-Type: application/json")
@FeignClient(name = "quotes-service", url = "http://localhost:8003")
//@FeignClient(name = "quotes-service", url = "${QUOTES_SERVICE:http://3.110.194.52:8666}")
public interface QuotesClient {
	
	@GetMapping("/quotes-api/getQuotesForPolicy") 
	public String quotesResponse
	(@Valid @RequestParam Long businessValue,@RequestParam Long propertyValue,@RequestParam String propertyType);

}
