package com.cognizant.exception;

public class ConsumerPropertyNotFound extends Exception{
	/**
	 * This class is for customizing the exception handler for ConsumerPropertyNotFoundException
	 */
	private static final long serialVersionUID = 1L;
	public ConsumerPropertyNotFound() {
		super();
	}
	public ConsumerPropertyNotFound(String msg) {
		super(msg);
	}
}
