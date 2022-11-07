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
 * Policy Master Entity Class
 * 
 */

@Entity
@Table(name="Policy_Master")
@AllArgsConstructor
public class PolicyMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID")
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "Policy_ID")
	private String pid;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "propertyType")
	private String propertyType;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "consumerType")
	private String consumerType;

	@NotBlank
	@Size(max = 40)
	@Column(name = "assuredSum")
	private String assuredSum;

	@NotBlank
	@Size(max = 30)
	@Column(name = "Tenure")
	private String tenure;

	@NotNull
	@Column(name = "businessValue")
	private Long businessValue;
	
	@NotNull
	@Column(name = "propertyValue")
	private Long propertyValue;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "baseLocation")
	private String baseLocation;
	
	@NotBlank
	@Size(max = 30)
	@Column(name = "Type")
	private String type;

	public PolicyMaster() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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

	@Override
	public String toString() {
		return "PolicyMaster [id=" + id + ", pid=" + pid + ", propertyType=" + propertyType + ", consumerType="
				+ consumerType + ", assuredSum=" + assuredSum + ", tenure=" + tenure + ", businessValue="
				+ businessValue + ", propertyValue=" + propertyValue + ", baseLocation=" + baseLocation + ", type="
				+ type + "]";
	}

	
}
