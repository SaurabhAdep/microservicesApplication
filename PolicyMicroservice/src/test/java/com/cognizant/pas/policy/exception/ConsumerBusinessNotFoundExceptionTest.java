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
public class ConsumerBusinessNotFoundExceptionTest {

	@Mock
	ConsumerBusinessNotFoundException consumerBusinessNotFoundException;

	@Test
	public void testOneArgConstructor() {
		ConsumerBusinessNotFoundException consumerBusinessNotFoundException = new ConsumerBusinessNotFoundException("Business not found");
		assertEquals("Business not found", consumerBusinessNotFoundException.getMessage());
	}
	

}
