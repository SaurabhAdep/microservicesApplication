package com.cognizant.payload;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
* 
* Model class for Storing both consumer and Business Details
* 
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConsumerBusinessRequest {
	
	@NotNull
	private Long consumerId;
	
	@NotBlank
	@Size(max = 50)
	private String firstName;
	
	@NotBlank
	@Size(max = 50)
	private String lastName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone="IST")
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
	private Long businessAge;

}
