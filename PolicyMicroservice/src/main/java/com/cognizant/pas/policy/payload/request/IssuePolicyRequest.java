package com.cognizant.pas.policy.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * Issue Policy Request POJO Class
 */
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
	public IssuePolicyRequest() {
		super();
	}
	public IssuePolicyRequest(@NotBlank String policyId, @NotNull Long consumerId, @NotNull Long businessId,
			@NotBlank String paymentDetails, @NotBlank String acceptanceStatus) {
		super();
		this.policyId = policyId;
		this.consumerId = consumerId;
		this.businessId = businessId;
		this.paymentDetails = paymentDetails;
		this.acceptanceStatus = acceptanceStatus;
	}
	public String getpolicyId() {
		return policyId;
	}
	public void setpolicyId(String policyId) {
		this.policyId = policyId;
	}
	public Long getconsumerId() {
		return consumerId;
	}
	public void setconsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}
	public Long getbusinessId() {
		return businessId;
	}
	public void setbusinessId(Long businessId) {
		this.businessId = businessId;
	}
	public String getpaymentDetails() {
		return paymentDetails;
	}
	public void setpaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public String getacceptanceStatus() {
		return acceptanceStatus;
	}
	public void setacceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

	
}
