package com.cognizant.pas.policy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.Generated;


/**
 * This is the main class for Policy Microservice Application
 * 
 * @author POD-4
 *
 */
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages={"com.cognizant"})
@EnableJpaRepositories
@OpenAPIDefinition
public class PolicyMicroserviceApplication {
	/**
	 * Main class
	 * 
	 * @param args
	 */
	@Generated
	public static void main(String[] args) {
		SpringApplication.run(PolicyMicroserviceApplication.class, args);
	}

}
