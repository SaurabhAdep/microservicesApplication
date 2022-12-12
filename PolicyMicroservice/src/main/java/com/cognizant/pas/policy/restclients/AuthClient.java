package com.cognizant.pas.policy.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import feign.Headers;


/**
 * Auth Client used for connection with Authorization MicroService
 */
@Headers("Content-Type: application/json")
@FeignClient(name="auth-service" , url="http://localhost:8000/auth")

public interface AuthClient {

	@GetMapping("/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);

}
