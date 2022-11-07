package com.cognizant.exception;

public class ConsumerNotFoundException extends Exception{
	/**
	 * This class is for customizing the exception handler for ConsumerNotFoundException
	 */
	private static final long serialVersionUID = 1L;
	public ConsumerNotFoundException() {
		super();
	}
	public ConsumerNotFoundException(String message) {
		super(message);
	}
}
