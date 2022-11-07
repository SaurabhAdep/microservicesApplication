package com.cognizant.pas.policy.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Create Policy Request POJO Class
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreatePolicyRequest {
	
	@NotNull
	private Long consumerId;
	@NotBlank
	private String acceptedQuotes;
	@NotBlank
	private String policeId;
	
	
	
}
