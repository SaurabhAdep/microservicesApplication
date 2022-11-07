package com.cognizant.payload;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//Model class for storing quote master details
public class QuotesMaster  {
	
	private Long id;
	
	@NotNull
	private Long businessValue;

	@NotNull
	private Long propertyValue;

	@NotBlank
	@Size(max = 50)
	private String propertyType;
	
	@NotBlank
	@Size(max = 50)
	private String quotes;
	
	

}
