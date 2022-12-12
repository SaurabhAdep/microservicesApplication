package com.cognizant.pas.policy.payload.response;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class PolicyDetailsResponseTest {
	private PolicyDetailsResponse pdr;

	
	@Test
	 void testAllGettersAndSettersOfPolicyDetailsResponse() {
		pdr = new PolicyDetailsResponse();
		pdr.setconsumerId((long)1);
		pdr.setpolicyId("Policy_ID");
		pdr.setpropertyValue((long)1);
		pdr.setconsumerType("consumerType");
		pdr.setassuredSum("assuredSum");
		pdr.setTenure("Tenure");
		pdr.setbusinessValue((long)1);
		pdr.setpropertyType("test");
		pdr.setbaseLocation("baseLocation");
		pdr.setType("Type");
		pdr.setbusinessId((long)1);
		pdr.setpaymentDetails("paymentDetails");
		pdr.setacceptanceStatus("acceptanceStatus");
		pdr.setpolicyStatus("policyStatus");
		pdr.seteffectiveDate("effectiveDate");
		pdr.setcoveredSum("coveredSum");
		pdr.setDuration("Duration");
		pdr.setacceptedQuote("acceptedQuote");
		assertEquals((long)1,pdr.getconsumerId());
		assertEquals("Policy_ID",pdr.getpolicyId());
		assertEquals("test",pdr.getpropertyType());
		assertEquals("consumerType",pdr.getconsumerType());
		assertEquals("assuredSum",pdr.getassuredSum());
		assertEquals("Tenure",pdr.getTenure());
		assertEquals((long)1,pdr.getbusinessValue());
		assertEquals((long)1,pdr.getpropertyValue());
		assertEquals("baseLocation",pdr.getbaseLocation());
		assertEquals("Type",pdr.getType());
		assertEquals((long)1,pdr.getbusinessId());
		assertEquals("paymentDetails",pdr.getpaymentDetails());
		assertEquals("acceptanceStatus",pdr.getacceptanceStatus());
		assertEquals("policyStatus",pdr.getpolicyStatus());
		assertEquals("effectiveDate",pdr.geteffectiveDate());
		assertEquals("coveredSum",pdr.getcoveredSum());
		assertEquals("Duration",pdr.getDuration());
		assertEquals("acceptedQuote",pdr.getacceptedQuote());	
		
	}
	
	@Test
	 void testPolicyDetailsResponseConstructor() {
		pdr = new PolicyDetailsResponse((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test",(long)1,"test","test","test","test","test","test","test");
		assertEquals((long)1,pdr.getconsumerId());
		assertEquals("test",pdr.getpolicyId());
		assertEquals("test",pdr.getpropertyType());
		assertEquals("test",pdr.getconsumerType());
		assertEquals("test",pdr.getassuredSum());
		assertEquals("test",pdr.getTenure());
		assertEquals((long)1,pdr.getbusinessValue());
		assertEquals((long)1,pdr.getpropertyValue());
		assertEquals("test",pdr.getbaseLocation());
		assertEquals("test",pdr.getType());
		assertEquals((long)1,pdr.getbusinessId());
		assertEquals("test",pdr.getpaymentDetails());
		assertEquals("test",pdr.getacceptanceStatus());
		assertEquals("test",pdr.getpolicyStatus());
		assertEquals("test",pdr.geteffectiveDate());
		assertEquals("test",pdr.getcoveredSum());
		assertEquals("test",pdr.getDuration());
		assertEquals("test",pdr.getacceptedQuote());	
		
	}

}
