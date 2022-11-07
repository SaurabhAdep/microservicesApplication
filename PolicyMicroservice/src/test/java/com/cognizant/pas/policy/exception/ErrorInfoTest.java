package com.cognizant.pas.policy.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test - CustomErrorResponse class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ErrorInfoTest {

	@Mock
	ErrorInfo errorInfo;

	

	@Test
	public void CustomErrorResponseAllConstructorTest() {
		ErrorInfo errorInfo = new ErrorInfo("Custom error response","Hello");
		assertEquals("Custom error response", errorInfo.getMessage());
	}
	@Test
	public void CustomErrorResponseNoConstructorTest() {
		ErrorInfo errorInfo = new ErrorInfo();
		assertEquals(null, errorInfo.getMessage());
		assertEquals(null, errorInfo.getUri());
	}

	@Test
	public void messageTest() {
		ErrorInfo errorInfo = new ErrorInfo("Custom error response","Hello");
		errorInfo.setMessage("Custom error response");
		assertEquals("Custom error response", errorInfo.getMessage());
	}

	@Test
	public void uriTest() {
		ErrorInfo errorInfo = new ErrorInfo("Custom error response","Hello");
		errorInfo.setUri("Hello");
		assertEquals("Hello", errorInfo.getUri());
	}

	@Test
	public void toStringTest() {
		ErrorInfo errorInfo = new ErrorInfo("Custom error response","Hello");
		String string = errorInfo.toString();
		assertEquals(string, errorInfo.toString());
	}

	@Test
	public void testEqualsMethod() {
		ErrorInfo errorInfo = new ErrorInfo("Custom error response","Hello");
		boolean equals = errorInfo.equals(errorInfo);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		ErrorInfo errorInfo = new ErrorInfo("Custom error response","Hello");
		int hashCode = errorInfo.hashCode();
		assertEquals(hashCode, errorInfo.hashCode());
	}

}
