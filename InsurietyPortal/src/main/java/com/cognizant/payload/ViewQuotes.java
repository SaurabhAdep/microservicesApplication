package com.cognizant.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ViewQuotes {
	@NotNull
	private long businessValue;
	@NotNull
	private long propertyValue;
	@NotBlank
	private String propertyType;
}
