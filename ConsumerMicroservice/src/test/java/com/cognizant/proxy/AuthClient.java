package com.cognizant.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 *  
 * 
 *         Feign provides an abstraction over REST-based calls via annotation,
 *         by which microservices can use to communicate with each other without
 *         writing detailed REST client code 
 *         In the @FeignClient annotation the
 *         String value ("AUTH") is an arbitrary client name, which is used to
 *         create a Ribbon load balancer
 */

@FeignClient(url="localhost:8081/auth",name="auth-service")
public interface AuthClient {
	@GetMapping(path="/validate")
	 Boolean verifyToken(@RequestHeader(name="Authorization",required=true)String token);
	
	
}
