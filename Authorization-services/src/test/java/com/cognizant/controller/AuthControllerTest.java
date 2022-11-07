package com.cognizant.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.exception.UserNameNumericException;
import com.cognizant.exception.UserNotFoundException;
import com.cognizant.model.MyUser;
import com.cognizant.model.UserCredentials;
import com.cognizant.repository.UserRepo;
import com.cognizant.service.UserDetailsServiceImpl;
import com.cognizant.util.JwtUtil;

/**
 * Test - AuthController class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthControllerTest {

	@InjectMocks
	AuthController authController;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtutil;

	@Mock
	UserDetailsServiceImpl custdetailservice;

	@Mock
	UserRepo userservice;

	@Test
	public void validLoginTest() {

		UserCredentials user = new UserCredentials("vijay", "vijay");
		UserDetails value = new User(user.getUserName(), user.getPassword(), new ArrayList<>());
		when(custdetailservice.loadUserByUsername("vijay")).thenReturn(value);
		when(jwtutil.generateToken(user.getUserName())).thenReturn("token");
		String login = authController.login(user);
		assertEquals("token", login);
	}

	@Test
	public void nullUserNameLoginTest() {
		UserCredentials user = new UserCredentials(null, "admin");
		assertThrows(UserNotFoundException.class ,()-> authController.login(user) );
		

	}

	@Test
	public void nullPasswordLoginTest() {
		UserCredentials user = new UserCredentials("admin", null);
		assertThrows(UserNotFoundException.class ,()-> authController.login(user) );
		

	}

	@Test
	public void emptyPasswordLoginTest() {
		UserCredentials user = new UserCredentials("admin", "");
		assertThrows(UserNotFoundException.class ,()-> authController.login(user) );
		

	}

	@Test
	public void emptyUserNameLoginTest() {
		UserCredentials user = new UserCredentials("", "admin");
		assertThrows(UserNotFoundException.class ,()-> authController.login(user) );
		

	}

	@Test
	public void userNameNumericLoginTest() {
		when(jwtutil.isNumeric("123")).thenReturn(true);
		UserCredentials user = new UserCredentials("123", "abc");
		assertThrows(UserNameNumericException.class ,()-> authController.login(user) );
		

	}

	@Test
	public void userNameNotFoundLoginTest() {
		UserCredentials user = new UserCredentials("123", "abc");
		Exception exception = assertThrows(UserNotFoundException.class, () -> {
			authController.login(user);
		});

		String expectedMessage = "Invalid Credential";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	
	@Test
	public void testHealthCheck(){
		assertEquals(200,authController.healthCheck().getStatusCodeValue());
	}

}
