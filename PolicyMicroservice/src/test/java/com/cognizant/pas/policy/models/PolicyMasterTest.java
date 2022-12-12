package com.cognizant.pas.policy.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class PolicyMasterTest {


	private PolicyMaster pm;

	
	 	@Test
	     void testAllGettersAndSettersOfPolicyMaster() {
		 pm = new PolicyMaster();
	        pm.setId((long)100);
	        pm.setPid("P01");
	        pm.setpropertyType("propertyType");
	        pm.setassuredSum("10,000");
	        pm.setbaseLocation("CHD");
	        pm.setbusinessValue(1L);
	        pm.setconsumerType("consumerType");
	        pm.setpropertyType("propertyType");
	        pm.setTenure("tenure");
	        pm.setType("type");
	        assertEquals(100,pm.getId());
	        assertEquals("P01",pm.getPid());
	        assertEquals("propertyType",pm.getpropertyType());
	        assertEquals("10,000",pm.getassuredSum());
	        assertEquals("CHD",pm.getbaseLocation());
	        assertEquals(1L,pm.getbusinessValue());
	        assertEquals("consumerType",pm.getconsumerType());
	        assertEquals("propertyType",pm.getpropertyType());
	        assertEquals("tenure",pm.getTenure());
	        assertEquals("type",pm.getType());
	    }
	 	
	 	@Test
	     void testPolicyMasterConstructor() {
		 pm = new PolicyMaster((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test");
	        assertEquals((long)1,pm.getId());
	        assertEquals("test",pm.getPid());
	        assertEquals("test",pm.getpropertyType());
	        assertEquals("test",pm.getassuredSum());
	        assertEquals("test",pm.getbaseLocation());
	        assertEquals((long)1,pm.getbusinessValue());
	        assertEquals("test",pm.getconsumerType());
	        assertEquals((long)1,pm.getpropertyValue());
	        assertEquals("test",pm.getTenure());
	        assertEquals("test",pm.getType());
	    }

}