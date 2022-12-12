package com.cognizant.pas.policy.payload.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class IssuePolicyRequestTest {
	private IssuePolicyRequest ipr;

	@Test
	  void testAllGettersAndSettersOfIssuePolicyRequest() {
		ipr = new IssuePolicyRequest();
		ipr.setpolicyId("Policy_ID");
		ipr.setconsumerId((long)1);
		ipr.setbusinessId((long)1);
		ipr.setpaymentDetails("Payment_Details");
		ipr.setacceptanceStatus("Acceptance_Status");
		assertEquals("Policy_ID",ipr.getpolicyId());
		assertEquals((long)1,ipr.getconsumerId());
		assertEquals((long)1,ipr.getbusinessId());
		assertEquals("Payment_Details",ipr.getpaymentDetails());
		assertEquals("Acceptance_Status",ipr.getacceptanceStatus());
	}
	
	@Test
	  void testIssuePolicyRequestConstructor() {
		ipr = new IssuePolicyRequest("test",(long)1,(long)1,"test","test");
		assertEquals("test",ipr.getpolicyId());
		assertEquals((long)1,ipr.getconsumerId());
		assertEquals((long)1,ipr.getbusinessId());
		assertEquals("test",ipr.getpaymentDetails());
		assertEquals("test",ipr.getacceptanceStatus());
	}
}

