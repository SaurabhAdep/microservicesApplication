package com.cognizant.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.payload.ConsumerBusinessRequest;



@ExtendWith(MockitoExtension.class)
 class ConsumerBusinessRequestTests {
	
	private ConsumerBusinessRequest consumerBusinessRequest;

	
	@Test
     void testConsumerBusinessRequest() throws Exception {
		consumerBusinessRequest=new ConsumerBusinessRequest();
		consumerBusinessRequest.setAgentID((long)1);
		consumerBusinessRequest.setAgentName("test");
		consumerBusinessRequest.setBusinessAge((long)1);
		consumerBusinessRequest.setBusinessCategory("test");
		consumerBusinessRequest.setBusinessName("test");
		consumerBusinessRequest.setBusinessOverview("test");
		consumerBusinessRequest.setBusinessTurnover((long)1);
		consumerBusinessRequest.setBusinessType("test");
		consumerBusinessRequest.setCapitalInvested((long)1);
		consumerBusinessRequest.setDob(new Date("28/04/2000"));
		consumerBusinessRequest.setEmail("test");
		consumerBusinessRequest.setFirstName("test");
		consumerBusinessRequest.setLastName("test");
		consumerBusinessRequest.setPanDetails("test");
		consumerBusinessRequest.setPhone("test");
		consumerBusinessRequest.setTotalEmployees((long)1);
		consumerBusinessRequest.setValidity("test");
		consumerBusinessRequest.setWebsite("test");
		assertEquals((long)1,consumerBusinessRequest.getAgentID());
		assertEquals("test",consumerBusinessRequest.getAgentName());
		assertEquals((long)1,consumerBusinessRequest.getBusinessAge());
		assertEquals("test",consumerBusinessRequest.getBusinessCategory());
		assertEquals("test",consumerBusinessRequest.getBusinessName());
		assertEquals("test",consumerBusinessRequest.getBusinessOverview());
		assertEquals((long)1,consumerBusinessRequest.getBusinessTurnover());
		assertEquals("test",consumerBusinessRequest.getBusinessType());
		assertEquals((long)1,consumerBusinessRequest.getCapitalInvested());
		assertEquals(new Date("28/04/2000"),consumerBusinessRequest.getDob());
		assertEquals("test",consumerBusinessRequest.getEmail());
		assertEquals("test",consumerBusinessRequest.getFirstName());
		assertEquals("test",consumerBusinessRequest.getLastName());
		assertEquals("test",consumerBusinessRequest.getPanDetails());
		assertEquals("test",consumerBusinessRequest.getPhone());
		assertEquals((long)1,consumerBusinessRequest.getTotalEmployees());
		assertEquals("test",consumerBusinessRequest.getValidity());
		assertEquals("test",consumerBusinessRequest.getWebsite());
	}
	
	@Test
     void testConsumerBusinessRequestConstructor() throws Exception {
		consumerBusinessRequest=new ConsumerBusinessRequest((long)1,"test","test",new Date("28/04/2000"),"test","test","test","test","test","test","test","test",(long)1,"test","test",(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,consumerBusinessRequest.getAgentID());
		assertEquals("test",consumerBusinessRequest.getAgentName());
		assertEquals((long)1,consumerBusinessRequest.getBusinessAge());
		assertEquals("test",consumerBusinessRequest.getBusinessCategory());
		assertEquals("test",consumerBusinessRequest.getBusinessName());
		assertEquals("test",consumerBusinessRequest.getBusinessOverview());
		assertEquals((long)1,consumerBusinessRequest.getBusinessTurnover());
		assertEquals("test",consumerBusinessRequest.getBusinessType());
		assertEquals((long)1,consumerBusinessRequest.getCapitalInvested());
		assertEquals(new Date("28/04/2000"),consumerBusinessRequest.getDob());
		assertEquals("test",consumerBusinessRequest.getEmail());
		assertEquals("test",consumerBusinessRequest.getFirstName());
		assertEquals("test",consumerBusinessRequest.getLastName());
		assertEquals("test",consumerBusinessRequest.getPanDetails());
		assertEquals("test",consumerBusinessRequest.getPhone());
		assertEquals((long)1,consumerBusinessRequest.getTotalEmployees());
		assertEquals("test",consumerBusinessRequest.getValidity());
		assertEquals("test",consumerBusinessRequest.getWebsite());
	}

}
