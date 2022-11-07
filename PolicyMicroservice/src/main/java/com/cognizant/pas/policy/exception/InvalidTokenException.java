package com.cognizant.pas.policy.exception;

/**
 * This is Invalid Token Exception
 */
public class InvalidTokenException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidTokenException() {
		super();
	}
	
	public InvalidTokenException(String message) {
		super(message);
	}
}
