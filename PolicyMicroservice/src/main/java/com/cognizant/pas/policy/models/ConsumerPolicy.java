package com.cognizant.pas.policy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;

/**
 * Consumer Policy Entity Class
 * 
 */
@Entity
@Table(name="Consumer_Policy")
@AllArgsConstructor
public class ConsumerPolicy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;
	
	@NotNull
	@Column(name = "Consumer_ID")
	private Long consumerId;
	
	@Size(max = 10)
	@Column(name = "Policy_ID")
	private String policyId;
	
	@NotNull
	@Column(name = "Business_ID")
	private Long businessId;
	
	@Size(max = 10)
	@Column(name = "Payment_Details")
	private String paymentDetails;
	
	@Size(max = 10)
	@Column(name = "Acceptance_Status")
	private String acceptanceStatus;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "Policy_Status")
	private String policyStatus;
	
	@Size(max = 20)
	@Column(name = "Effective_Date")
	private String effectiveDate;
	
	@Size(max = 15)
	@Column(name = "coveredSum")
	private String coveredSum;
	
	
	@Size(max = 15)
	@Column(name = "Duration")
	private String duration;
	
	@NotBlank
	@Size(max = 15)
	@Column(name = "Accepted_Quotes")
	private String acceptedQuote;
	
	

	public ConsumerPolicy() {
		super();
	}



	public ConsumerPolicy(@NotNull Long consumerId, @NotNull Long businessId,
			@NotBlank @Size(max = 10) String policyStatus, @NotBlank @Size(max = 15) String acceptedQuote) {
		super();
		this.consumerId = consumerId;
		this.businessId = businessId;
		this.policyStatus = policyStatus;
		this.acceptedQuote = acceptedQuote;
	}
	
	



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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
		return "ConsumerPolicy [id=" + id + ", consumerId=" + consumerId + ", policyId=" + policyId + ", businessId="
				+ businessId + ", paymentDetails=" + paymentDetails + ", acceptanceStatus=" + acceptanceStatus
				+ ", policyStatus=" + policyStatus + ", effectiveDate=" + effectiveDate + ", coveredSum=" + coveredSum
				+ ", duration=" + duration + ", acceptedQuote=" + acceptedQuote + "]";
	}



	


	
	
}
