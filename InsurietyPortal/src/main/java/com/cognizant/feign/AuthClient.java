package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.LoginModel;

import feign.Headers;


//@FeignClient(name = "auth-service", url = "13.232.171.53:8081/auth")
@FeignClient(name = "auth-service", url = "http://localhost:8000/auth")
public interface AuthClient {

	@GetMapping("/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);

	@PostMapping("/login")
	public String login(@RequestBody LoginModel model);

}
