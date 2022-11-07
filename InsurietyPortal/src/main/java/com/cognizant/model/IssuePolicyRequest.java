package com.cognizant.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IssuePolicyRequest {
	@NotBlank
	private String policyId;
	@NotNull
	private Long consumerId;
	@NotNull
	private Long businessId;
	@NotBlank
	private String paymentDetails;
	@NotBlank
	private String acceptanceStatus;
	
	
}
