package com.cognizant.pas.policy.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ConsumerPolicyTest {


private ConsumerPolicy consumerPolicy;
	
	
	@Test
     void testConsumerPolicy() throws Exception {
		consumerPolicy= new ConsumerPolicy();
		consumerPolicy.setacceptanceStatus("acceptanceStatus");
		consumerPolicy.setacceptedQuote("acceptedQuote");
		consumerPolicy.setbusinessId((long)1);
		consumerPolicy.setconsumerId((long)1);
		consumerPolicy.setcoveredSum("coveredSum");
		consumerPolicy.setDuration("duration");
		consumerPolicy.seteffectiveDate("effectiveDate");
		consumerPolicy.setId((long)1);
		consumerPolicy.setpaymentDetails("paymentDetails");
		consumerPolicy.setpolicyId("policyId");
		consumerPolicy.setpolicyStatus("policyStatus");
		assertEquals("acceptanceStatus",consumerPolicy.getacceptanceStatus());
		assertEquals("acceptedQuote",consumerPolicy.getacceptedQuote());
		assertEquals((long)1,consumerPolicy.getbusinessId());
		assertEquals((long)1,consumerPolicy.getconsumerId());
		assertEquals("coveredSum",consumerPolicy.getcoveredSum());
		assertEquals("duration",consumerPolicy.getDuration());
		assertEquals("effectiveDate",consumerPolicy.geteffectiveDate());
		assertEquals((long)1,consumerPolicy.getId());
		assertEquals("paymentDetails",consumerPolicy.getpaymentDetails());
		assertEquals("policyId",consumerPolicy.getpolicyId());
		assertEquals("policyStatus",consumerPolicy.getpolicyStatus());	
	}
	
	@Test
     void testConsumerPolicyAllConstructor() throws Exception {
		consumerPolicy= new ConsumerPolicy((long)1,(long)1,"test",(long)1,"test","test","test","test","test","test","test");
		assertEquals("test",consumerPolicy.getacceptanceStatus());
		assertEquals("test",consumerPolicy.getacceptedQuote());
		assertEquals((long)1,consumerPolicy.getbusinessId());
		assertEquals((long)1,consumerPolicy.getconsumerId());
		assertEquals("test",consumerPolicy.getcoveredSum());
		assertEquals("test",consumerPolicy.getDuration());
		assertEquals("test",consumerPolicy.geteffectiveDate());
		assertEquals((long)1,consumerPolicy.getId());
		assertEquals("test",consumerPolicy.getpaymentDetails());
		assertEquals("test",consumerPolicy.getpolicyId());
		assertEquals("test",consumerPolicy.getpolicyStatus());	
	}

	
	@Test
     void testConsumerPolicyConstructor() throws Exception {
		consumerPolicy= new ConsumerPolicy((long)1,(long)1,"test","test");
		assertEquals("test",consumerPolicy.getacceptedQuote());
		assertEquals((long)1,consumerPolicy.getbusinessId());
		assertEquals((long)1,consumerPolicy.getconsumerId());
		assertEquals("test",consumerPolicy.getpolicyStatus());	
	}

}