package com.cognizant.pas.policy.payload.response;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;

/**
 * Consumer Business Response POJO Class
 */
@AllArgsConstructor
public class ConsumerBusinessResponse {

	@NotNull
	private Long consumerID;
	@NotBlank
	@Size(max = 50)
	private String firstName;
	@NotBlank
	@Size(max = 50)
	private String lastName;
	@NotBlank
	@Size(max = 20)
	private Date dob;
	@NotBlank
	@Size(max = 50)
	private String businessName;
	@NotBlank
	@Size(max = 12)
	private String panDetails;
	@NotBlank
	@Size(max = 50)
	private String email;
	@NotBlank
	@Size(max = 10)
	private String phone;
	@NotBlank
	@Size(max = 40)
	private String website;
	@NotBlank
	@Size(max = 150)
	private String businessOverview;
	@NotBlank
	@Size(max = 30)
	private String validity;
	@NotBlank
	@Size(max = 50)
	private String agentName;
	@NotNull
	private Long agentID;
	@NotNull
	private Long businessID;
	
	@NotBlank
	@Size(max = 40)
	private String businessCategory;
	@NotBlank
	@Size(max = 40)
	private String businessType;
	@NotNull
	private Long businessTurnover;
	@NotNull
	private Long capitalInvested;
	@NotNull
	private Long totalEmployees;
	@NotNull
	private Long businessValue;
	@NotNull
	private Long businessAge;
	public ConsumerBusinessResponse() {
		super();
	}

	public Long getConsumerID() {
		return consumerID;
	}
	public void setConsumerID(Long consumerID) {
		this.consumerID = consumerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getPanDetails() {
		return panDetails;
	}
	public void setPanDetails(String panDetails) {
		this.panDetails = panDetails;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getBusinessOverview() {
		return businessOverview;
	}
	public void setBusinessOverview(String businessOverview) {
		this.businessOverview = businessOverview;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Long getAgentID() {
		return agentID;
	}
	public void setAgentID(Long agentID) {
		this.agentID = agentID;
	}
	public Long getBusinessID() {
		return businessID;
	}
	public void setBusinessID(Long businessID) {
		this.businessID = businessID;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public Long getBusinessTurnover() {
		return businessTurnover;
	}
	public void setBusinessTurnover(Long businessTurnover) {
		this.businessTurnover = businessTurnover;
	}
	public Long getCapitalInvested() {
		return capitalInvested;
	}
	public void setCapitalInvested(Long capitalInvested) {
		this.capitalInvested = capitalInvested;
	}
	public Long getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(Long totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	public Long getBusinessValue() {
		return businessValue;
	}
	public void setBusinessValue(Long businessValue) {
		this.businessValue = businessValue;
	}
	public Long getBusinessAge() {
		return businessAge;
	}
	public void setBusinessAge(Long businessAge) {
		this.businessAge = businessAge;
	}
	@Override
	public String toString() {
		return "ConsumerBusinessDetails [consumerID=" + consumerID + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", businessName=" + businessName + ", panDetails=" + panDetails
				+ ", email=" + email + ", phone=" + phone + ", website=" + website + ", businessOverview="
				+ businessOverview + ", validity=" + validity + ", agentName=" + agentName + ", agentID=" + agentID
				+ ", businessID=" + businessID + ", businessCategory=" + businessCategory + ", businessType="
				+ businessType + ", businessTurnover=" + businessTurnover + ", capitalInvested=" + capitalInvested
				+ ", totalEmployees=" + totalEmployees + ", businessValue=" + businessValue + ", businessAge="
				+ businessAge + "]";
	}

	
}
