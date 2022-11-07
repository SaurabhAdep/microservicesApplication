package com.cognizant.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is for customizing the exception handler for stroing exception url and message
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorInfo {
	private String message;
	private String uri;
	
}
