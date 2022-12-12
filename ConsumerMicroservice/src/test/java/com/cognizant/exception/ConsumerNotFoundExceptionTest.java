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
public class ConsumerNotFoundExceptionTest {

	@Mock
	ConsumerNotFoundException consumerNotFoundException;

	@Test
	public void testOneArgConstructor() {
		ConsumerNotFoundException consumerNotFoundException = new ConsumerNotFoundException("Consumer not found");
		assertEquals("Consumer not found",consumerNotFoundException.getMessage());
	}
	@Test
	public void testtOneArgConstructor() {
		ConsumerNotFoundException consumerNotFoundException = new ConsumerNotFoundException();
		assertEquals(null,consumerNotFoundException.getMessage());
	}

}
