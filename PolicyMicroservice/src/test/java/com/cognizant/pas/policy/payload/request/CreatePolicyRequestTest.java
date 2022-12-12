package com.cognizant.pas.policy.payload.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CreatePolicyRequestTest {
	private CreatePolicyRequest cpr;

	@Test
	  void testAllGettersAndSettersOfCreatePolicyRequest() {
		cpr = new CreatePolicyRequest();
		cpr.setConsumerId((long)1);
		cpr.setAcceptedQuotes("Accepted_Quotes");
		assertEquals(1,cpr.getConsumerId());
		assertEquals("Accepted_Quotes",cpr.getAcceptedQuotes());
	}
	
	@Test
	  void testCreatePolicyRequestConstructor() {
		cpr = new CreatePolicyRequest((long)1,"Accepted_Quotes",null);
		assertEquals(1,cpr.getConsumerId());
		assertEquals("Accepted_Quotes",cpr.getAcceptedQuotes());
	}

}
