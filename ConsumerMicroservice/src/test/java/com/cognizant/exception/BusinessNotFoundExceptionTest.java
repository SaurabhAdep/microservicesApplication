package com.cognizant.exception;

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
public class BusinessNotFoundExceptionTest {

	@Mock
	BusinessNotFoundException businessNotFoundException;

	@Test
	public void testOneArgConstructor() {
		BusinessNotFoundException userNotFoundException = new BusinessNotFoundException("Business not found");
		assertEquals("Business not found", userNotFoundException.getMessage());
	}
	@Test
	public void testtOneArgConstructor() {
		BusinessNotFoundException userNotFoundException = new BusinessNotFoundException();
		assertEquals(null, userNotFoundException.getMessage());
	}

}
