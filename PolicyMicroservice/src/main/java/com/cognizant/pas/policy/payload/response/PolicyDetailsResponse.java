package com.cognizant.pas.policy.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;

/**
 * Policy Details Response POJO Class
 */
@AllArgsConstructor
public class PolicyDetailsResponse {
	
	@NotNull
	private Long consumerId;
	
	@NotBlank
	@Size(max = 10)
	private String policyId;
	
	@NotBlank
	@Size(max = 30)
	private String propertyType;
	
	@NotBlank
	@Size(max = 30)
	private String consumerType;

	@NotBlank
	@Size(max = 40)
	private String assuredSum;

	@NotBlank
	@Size(max = 30)
	private String tenure;

	@NotNull
	private Long businessValue;

	@NotNull
	private Long propertyValue;

	@NotBlank
	@Size(max = 30)
	private String baseLocation;
	
	@NotBlank
	@Size(max = 30)
	private String type;
	
	@NotNull
	private Long businessId;
	
	@NotBlank
	@Size(max = 10)
	private String paymentDetails;
	
	@NotBlank
	@Size(max = 10)
	private String acceptanceStatus;
	
	@NotBlank
	@Size(max = 10)
	private String policyStatus;
	
	@NotBlank
	@Size(max = 15)
	private String effectiveDate;
	
	@NotBlank
	@Size(max = 15)
	private String coveredSum;
	
	@NotBlank
	@Size(max = 15)
	private String duration;
	
	@NotBlank
	@Size(max = 15)
	private String acceptedQuote;

	public PolicyDetailsResponse() {
		super();
	}

	

	public Long getconsumerId() {
		return consumerId;
	}

	public void setconsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public String getpolicyId() {
		return policyId;
	}

	public void setpolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getpropertyType() {
		return propertyType;
	}

	public void setpropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getconsumerType() {
		return consumerType;
	}

	public void setconsumerType(String consumerType) {
		this.consumerType = consumerType;
	}

	public String getassuredSum() {
		return assuredSum;
	}

	public void setassuredSum(String assuredSum) {
		this.assuredSum = assuredSum;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public Long getbusinessValue() {
		return businessValue;
	}

	public void setbusinessValue(Long businessValue) {
		this.businessValue = businessValue;
	}

	public Long getpropertyValue() {
		return propertyValue;
	}

	public void setpropertyValue(Long propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getbaseLocation() {
		return baseLocation;
	}

	public void setbaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getpolicyStatus() {
		return policyStatus;
	}

	public void setpolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String geteffectiveDate() {
		return effectiveDate;
	}

	public void seteffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getcoveredSum() {
		return coveredSum;
	}

	public void setcoveredSum(String coveredSum) {
		this.coveredSum = coveredSum;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getacceptedQuote() {
		return acceptedQuote;
	}

	public void setacceptedQuote(String acceptedQuote) {
		this.acceptedQuote = acceptedQuote;
	}

	@Override
	public String toString() {
		return "PolicyDetailsResponse [consumerId=" + consumerId + ", policyId=" + policyId + ", propertyType="
				+ propertyType + ", consumerType=" + consumerType + ", assuredSum=" + assuredSum + ", tenure="
				+ tenure + ", businessValue=" + businessValue + ", propertyValue=" + propertyValue
				+ ", baseLocation=" + baseLocation + ", type=" + type + ", businessId=" + businessId
				+ ", paymentDetails=" + paymentDetails + ", acceptanceStatus=" + acceptanceStatus + ", policyStatus="
				+ policyStatus + ", effectiveDate=" + effectiveDate + ", coveredSum=" + coveredSum + ", duration="
				+ duration + ", acceptedQuote=" + acceptedQuote + "]";
	}
	
	
}
