package com.cognizant.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ViewPolicePropertyRequest {
	@NotNull
	private long consumerId;
	
	@NotNull
	private long propertyId;
	
	private String policeId;
	
}
