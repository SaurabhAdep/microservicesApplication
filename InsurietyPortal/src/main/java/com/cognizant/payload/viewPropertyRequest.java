package com.cognizant.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class viewPropertyRequest {
	
	private Long consumerId;
	
	private Long propertyId;

}
