package com.cognizant.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ViewPolicyRequest {

	@NotNull
	private Long consumerid;
	
	@NotBlank
	private String policyid;

	public ViewPolicyRequest() {
		super();
	}

	public ViewPolicyRequest(@NotNull Long consumerid, @NotBlank String policyid) {
		super();
		this.consumerid = consumerid;
		this.policyid = policyid;
	}

	public Long getConsumerid() {
		return consumerid;
	}

	public void setConsumerid(Long consumerid) {
		this.consumerid = consumerid;
	}

	public String getPolicyid() {
		return policyid;
	}

	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}

	@Override
	public String toString() {
		return "ViewPolicyRequest [consumerid=" + consumerid + ", policyid=" + policyid + "]";
	}
	
	
}
