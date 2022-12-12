package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import lombok.Value;


@FeignClient(name="auth-service" , url = "http://localhost:8000/auth")

public interface AuthClient {

	@GetMapping("/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);
	
}
