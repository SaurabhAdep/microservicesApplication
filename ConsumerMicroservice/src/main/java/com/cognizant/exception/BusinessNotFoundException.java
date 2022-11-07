package com.cognizant.exception;

public class BusinessNotFoundException extends Exception{
	/**
	 * This class is for customizing the exception handler for BusinessNotFoundException
	 */
	private static final long serialVersionUID = 1L;
	public BusinessNotFoundException() {
		super();
	}
	public BusinessNotFoundException(String message) {
		super(message);
	}
}
