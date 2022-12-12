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
public class ConsumerPropertyNotFoundTest {

	@Mock
	ConsumerPropertyNotFound consumerPropertyNotFound;

	@Test
	public void testOneArgConstructor() {
		ConsumerPropertyNotFound consumerPropertyNotFound = new ConsumerPropertyNotFound("Consumer Property Not Found");
		assertEquals("Consumer Property Not Found",consumerPropertyNotFound.getMessage());
	}
	@Test
	public void testtOneArgConstructor() {
		ConsumerPropertyNotFound consumerPropertyNotFound = new ConsumerPropertyNotFound();
		assertEquals(null,consumerPropertyNotFound.getMessage());
	}

}
