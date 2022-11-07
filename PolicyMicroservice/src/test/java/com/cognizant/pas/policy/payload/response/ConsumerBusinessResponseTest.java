package com.cognizant.pas.policy.payload.response;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)

class ConsumerBusinessResponseTest {
	private ConsumerBusinessResponse cbd;


	@Test
	 void testAllGettersAndSettersOfConsumerBusinessDetails() {
		cbd = new ConsumerBusinessResponse();
		cbd.setFirstName("First_Name");
		cbd.setLastName("Last_Name");
		cbd.setDob(new Date("28/04/2000"));
		cbd.setBusinessName("Business_Name");
		cbd.setPanDetails("PANDetails");
		cbd.setEmail("EMAIL");
		cbd.setPhone("Phone");
		cbd.setWebsite("WebSite");
		cbd.setBusinessOverview("BusinessOverview");
		cbd.setValidity("Validity");
		cbd.setAgentName("AgentName");
		cbd.setAgentID((long)1);
		cbd.setBusinessID((long)1);
		cbd.setConsumerID((long)1);
		cbd.setBusinessCategory("BusinessCategory");
		cbd.setBusinessType("Business_Type");
		cbd.setBusinessTurnover((long)1);
		cbd.setCapitalInvested((long)1);
		cbd.setTotalEmployees((long)1);
		cbd.setBusinessValue((long)1);
		cbd.setBusinessAge((long)1);
		assertEquals("First_Name",cbd.getFirstName());
		assertEquals("Last_Name",cbd.getLastName());
		assertEquals(new Date("28/04/2000"),cbd.getDob());
		assertEquals("Business_Name",cbd.getBusinessName());
		assertEquals("PANDetails",cbd.getPanDetails());
		assertEquals("EMAIL",cbd.getEmail());
		assertEquals("Phone",cbd.getPhone());
		assertEquals("WebSite",cbd.getWebsite());
		assertEquals("BusinessOverview",cbd.getBusinessOverview());
		assertEquals("Validity",cbd.getValidity());
		assertEquals("AgentName",cbd.getAgentName());
		assertEquals((long)1,cbd.getAgentID());
		assertEquals((long)1,cbd.getBusinessID());
		assertEquals((long)1,cbd.getConsumerID());
		assertEquals("BusinessCategory",cbd.getBusinessCategory());
		assertEquals("Business_Type",cbd.getBusinessType());
		assertEquals((long)1,cbd.getBusinessTurnover());
		assertEquals((long)1,cbd.getCapitalInvested());
		assertEquals((long)1,cbd.getTotalEmployees());
		assertEquals((long)1,cbd.getBusinessValue());
		assertEquals((long)1,cbd.getBusinessAge());
	
	}
	
	@Test
	 void testConsumerBusinessDetailsConstructor() {
		cbd = new ConsumerBusinessResponse((long)1,"test","test",new Date("28/04/2000"),"test","test","test","test","test","test","test","test",(long)1,(long)1,"test","test",(long)1,(long)1,(long)1,(long)1,(long)1);		
		assertEquals("test",cbd.getFirstName());
		assertEquals("test",cbd.getLastName());
		assertEquals(new Date("28/04/2000"),cbd.getDob());
		assertEquals("test",cbd.getBusinessName());
		assertEquals("test",cbd.getPanDetails());
		assertEquals("test",cbd.getEmail());
		assertEquals("test",cbd.getPhone());
		assertEquals("test",cbd.getWebsite());
		assertEquals("test",cbd.getBusinessOverview());
		assertEquals("test",cbd.getValidity());
		assertEquals("test",cbd.getAgentName());
		assertEquals((long)1,cbd.getAgentID());
		assertEquals((long)1,cbd.getBusinessID());
		assertEquals((long)1,cbd.getConsumerID());
		assertEquals("test",cbd.getBusinessCategory());
		assertEquals("test",cbd.getBusinessType());
		assertEquals((long)1,cbd.getBusinessTurnover());
		assertEquals((long)1,cbd.getCapitalInvested());
		assertEquals((long)1,cbd.getTotalEmployees());
		assertEquals((long)1,cbd.getBusinessValue());
		assertEquals((long)1,cbd.getBusinessAge());
	
	}

}
