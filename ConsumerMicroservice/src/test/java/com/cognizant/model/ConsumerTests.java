package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
 class ConsumerTests {
	
	private Consumer consumer;
	
	
	@Test
     void testConsumerDetails() throws Exception {
		consumer =new Consumer();
		consumer.setAgentID((long)1);
		consumer.setAgentName("name");
		consumer.setBusinessName("bname");
		consumer.setBusinessOverview("overview");
		consumer.setDob(new SimpleDateFormat("yyyy-dd-MM").parse("2000-10-10"));
		consumer.setEmail("email");
		consumer.setFirstName("fname");
		consumer.setId((long)1);
		consumer.setLastName("lname");
		consumer.setPanDetails("pan");
		consumer.setPhone("phone");
		consumer.setValidity("val");
		consumer.setWebsite("web");
		assertEquals((long)1,consumer.getAgentID());
		assertEquals("name",consumer.getAgentName());
		assertEquals("bname",consumer.getBusinessName());
		assertEquals("overview",consumer.getBusinessOverview());
		assertEquals(new SimpleDateFormat("yyyy-dd-MM").parse("2000-10-10"),consumer.getDob());
		assertEquals("email",consumer.getEmail());
		assertEquals("fname",consumer.getFirstName());
		assertEquals((long)1,consumer.getId());
		assertEquals("lname",consumer.getLastName());
		assertEquals("pan",consumer.getPanDetails());
		assertEquals("phone",consumer.getPhone());
		assertEquals("val",consumer.getValidity());
		assertEquals("web",consumer.getWebsite());
	}
	
	@Test
     void testConsumerAllArgsConstructor() throws Exception {
		consumer =new Consumer((long)1,"test","test",new SimpleDateFormat("yyyy-dd-MM").parse("2000-10-10"),"test","test","test","test","test","test","test","test",(long)1,null,null);
		assertEquals((long)1,consumer.getAgentID());
		assertEquals("test",consumer.getAgentName());
		assertEquals("test",consumer.getBusinessName());
		assertEquals("test",consumer.getBusinessOverview());
		assertEquals(new SimpleDateFormat("yyyy-dd-MM").parse("2000-10-10"),consumer.getDob());
		assertEquals("test",consumer.getEmail());
		assertEquals("test",consumer.getFirstName());
		assertEquals((long)1,consumer.getId());
		assertEquals("test",consumer.getLastName());
		assertEquals("test",consumer.getPanDetails());
		assertEquals("test",consumer.getPhone());
		assertEquals("test",consumer.getValidity());
		assertEquals("test",consumer.getWebsite());
	}
	@Test
	public void toStringTest() throws Exception {
		consumer =new Consumer((long)1,"test","test",new SimpleDateFormat("yyyy-dd-MM").parse("2000-10-10"),"test","test","test","test","test","test","test","test",(long)1,null,null);
		String string  = consumer.toString();
		assertEquals(string, consumer.toString());
	}

}
