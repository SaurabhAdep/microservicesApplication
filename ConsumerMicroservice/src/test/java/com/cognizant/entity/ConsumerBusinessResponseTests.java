package com.cognizant.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.payload.ConsumerBusinessResponse;


@ExtendWith(MockitoExtension.class)
 class ConsumerBusinessResponseTests {

	private ConsumerBusinessResponse consumerBusinessResponse;
	
	
	@Test
     void testconsumerBusinessResponse() throws Exception {
		consumerBusinessResponse=new ConsumerBusinessResponse();
		consumerBusinessResponse.setAgentID((long)1);
		consumerBusinessResponse.setAgentName("test");
		consumerBusinessResponse.setBusinessAge((long)1);
		consumerBusinessResponse.setBusinessCategory("test");
		consumerBusinessResponse.setBusinessName("test");
		consumerBusinessResponse.setBusinessOverview("test");
		consumerBusinessResponse.setBusinessTurnover((long)1);
		consumerBusinessResponse.setBusinessType("test");
		consumerBusinessResponse.setCapitalInvested((long)1);
		consumerBusinessResponse.setDob(new Date("28/04/2000"));
		consumerBusinessResponse.setEmail("test");
		consumerBusinessResponse.setFirstName("test");
		consumerBusinessResponse.setLastName("test");
		consumerBusinessResponse.setPanDetails("test");
		consumerBusinessResponse.setPhone("test");
		consumerBusinessResponse.setTotalEmployees((long)1);
		consumerBusinessResponse.setValidity("test");
		consumerBusinessResponse.setWebsite("test");
		consumerBusinessResponse.setBusinessID((long)1);
		consumerBusinessResponse.setConsumerID((long)1);
		assertEquals((long)1,consumerBusinessResponse.getAgentID());
		assertEquals("test",consumerBusinessResponse.getAgentName());
		assertEquals((long)1,consumerBusinessResponse.getBusinessAge());
		assertEquals("test",consumerBusinessResponse.getBusinessCategory());
		assertEquals("test",consumerBusinessResponse.getBusinessName());
		assertEquals("test",consumerBusinessResponse.getBusinessOverview());
		assertEquals((long)1,consumerBusinessResponse.getBusinessTurnover());
		assertEquals("test",consumerBusinessResponse.getBusinessType());
		assertEquals((long)1,consumerBusinessResponse.getCapitalInvested());
		assertEquals(new Date("28/04/2000"),consumerBusinessResponse.getDob());
		assertEquals("test",consumerBusinessResponse.getEmail());
		assertEquals("test",consumerBusinessResponse.getFirstName());
		assertEquals("test",consumerBusinessResponse.getLastName());
		assertEquals("test",consumerBusinessResponse.getPanDetails());
		assertEquals("test",consumerBusinessResponse.getPhone());
		assertEquals((long)1,consumerBusinessResponse.getTotalEmployees());
		assertEquals("test",consumerBusinessResponse.getValidity());
		assertEquals("test",consumerBusinessResponse.getWebsite());
		assertEquals((long)1,consumerBusinessResponse.getBusinessID());
		assertEquals((long)1,consumerBusinessResponse.getConsumerID());
	}
	
	@Test
     void testconsumerBusinessResponseConstructor() throws Exception {
		consumerBusinessResponse=new ConsumerBusinessResponse((long)1,"test","test",new Date("28/04/2000"),"test","test","test","test","test","test","test","test",(long)1,(long)1,"test","test",(long)1,(long)1,(long)1,(long)1,(long)1);		
		assertEquals((long)1,consumerBusinessResponse.getAgentID());
		assertEquals("test",consumerBusinessResponse.getAgentName());
		assertEquals((long)1,consumerBusinessResponse.getBusinessAge());
		assertEquals("test",consumerBusinessResponse.getBusinessCategory());
		assertEquals("test",consumerBusinessResponse.getBusinessName());
		assertEquals("test",consumerBusinessResponse.getBusinessOverview());
		assertEquals((long)1,consumerBusinessResponse.getBusinessTurnover());
		assertEquals("test",consumerBusinessResponse.getBusinessType());
		assertEquals((long)1,consumerBusinessResponse.getCapitalInvested());
		assertEquals(new Date("28/04/2000"),consumerBusinessResponse.getDob());
		assertEquals("test",consumerBusinessResponse.getEmail());
		assertEquals("test",consumerBusinessResponse.getFirstName());
		assertEquals("test",consumerBusinessResponse.getLastName());
		assertEquals("test",consumerBusinessResponse.getPanDetails());
		assertEquals("test",consumerBusinessResponse.getPhone());
		assertEquals((long)1,consumerBusinessResponse.getTotalEmployees());
		assertEquals("test",consumerBusinessResponse.getValidity());
		assertEquals("test",consumerBusinessResponse.getWebsite());
		assertEquals((long)1,consumerBusinessResponse.getBusinessID());
		assertEquals((long)1,consumerBusinessResponse.getConsumerID());
	}
}
