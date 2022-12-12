package com.cognizant.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * This class is a controlleradivce for exception handling 
 */

@ControllerAdvice
public class ExceptionAOP {
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {Exception.class})
	public ErrorInfo hadleException(Exception exception,HttpServletRequest request) {
		String message = exception.getMessage();
		String uri = request.getRequestURI();
		return(new ErrorInfo(message,uri));
	}
}
