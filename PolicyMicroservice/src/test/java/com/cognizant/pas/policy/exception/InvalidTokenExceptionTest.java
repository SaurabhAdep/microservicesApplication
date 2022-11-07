package com.cognizant.pas.policy.exception;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test - UserNotFoundException class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class InvalidTokenExceptionTest {

	@Mock
	InvalidTokenException invalidTokenException;

	@Test
	public void testOneArgConstructor() {
		InvalidTokenException invalidTokenException = new InvalidTokenException("Invalid Token");
		assertEquals("Invalid Token",invalidTokenException.getMessage());
	}
	@Test
	public void testtOneArgConstructor() {
		InvalidTokenException invalidTokenException = new InvalidTokenException();
		assertEquals(null,invalidTokenException.getMessage());
	}

}
