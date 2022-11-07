package com.cognizant.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test - UserCredentials class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserCredentialsTest {

	@Mock
	UserCredentials userCredentials;

	@Before
	public void setUp() {
		UserCredentials userCredentials = new UserCredentials("vishal", "abc");
	}

	@Test
	public void userCredentialsAllConstructorTest() {
		UserCredentials userCredentials = new UserCredentials("vishal", "abc");
		assertEquals("vishal", userCredentials.getUserName());
	}

	@Test
	public void userNameTest() {
		UserCredentials userCredentials = new UserCredentials("vishal", "abc");
		assertEquals("vishal", userCredentials.getUserName());
	}

	@Test
	public void passwordTest() {
		UserCredentials userCredentials = new UserCredentials("vishal", "abc");
		assertEquals("abc", userCredentials.getPassword());
	}

	@Test
	public void toStringTest() {
		UserCredentials userCredentials = new UserCredentials("vishal", "abc");
		String string = userCredentials.toString();
		assertEquals(string,userCredentials.toString());
	}

	@Test
	public void testEqualsMethod() {
		UserCredentials userCredentials = new UserCredentials("vishal", "abc");
		boolean equals = userCredentials.equals(userCredentials);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		UserCredentials userCredentials = new UserCredentials("vishal", "abc");
		int hashCode = userCredentials.hashCode();
		assertEquals(hashCode,userCredentials.hashCode());
	}

}
