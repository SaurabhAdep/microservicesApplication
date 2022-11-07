package com.cognizant.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * Test - MyUser class
 */
public class MyUserTest {

	@Mock
	MyUser user;

	@Before
	public void setUp() {
		MyUser user = new MyUser(1, "vishal", "abc");
	}

	@Test
	public void userCredentialsAllConstructorTest() {
		MyUser user = new MyUser(1, "vishal", "abc");
		assertEquals("vishal", user.getUserName());
	}

	@Test
	public void userIdTest() {
		MyUser user = new MyUser(1, "vishal", "abc");
		assertEquals(1, user.getUserId());
	}

	@Test
	public void userNameTest() {
		MyUser user = new MyUser(1, "vishal", "abc");
		assertEquals("vishal", user.getUserName());
	}

	@Test
	public void passwordTest() {
		MyUser user = new MyUser(1, "vishal", "abc");
		assertEquals("abc", user.getPassword());
	}

	@Test
	public void toStringTest() {
		MyUser user = new MyUser(1, "vishal", "abc");
		String string = user.toString();
		assertEquals(string, user.toString());
	}

	@Test
	public void testEqualsMethod() {
		MyUser user = new MyUser(1, "vishal", "abc");
		boolean equals = user.equals(user);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		MyUser user = new MyUser(1, "vishal", "abc");
		int hashCode = user.hashCode();
		assertEquals(hashCode, user.hashCode());
	}

}
