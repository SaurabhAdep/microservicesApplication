package com.cognizant.pas.policy.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pas.policy.models.PolicyMaster;

@ExtendWith(MockitoExtension.class)
class PolicyMasterTest {


	private PolicyMaster pm;
	@BeforeEach()
     void setUp() {
        pm = new PolicyMaster();
        pm.setId(100L);
        pm.setPid("P01");
        pm.setpropertyType("property_type");
        pm.setassuredSum("10,000");
        pm.setbaseLocation("CHD");
        pm.setbusinessValue(1L);
        pm.setconsumerType("consumer_type");
        pm.setpropertyType("property_type");
        pm.setTenure("tenure");
        pm.setType("type");
              
        
    }
	
	 @Test
	     void testAllGettersAndSettersOfPolicyMaster() {
	        assertEquals(100L,pm.getId());
	        assertEquals("P01",pm.getPid());
	        assertEquals("property_type",pm.getpropertyType());
	        assertEquals("10,000",pm.getassuredSum());
	        assertEquals("CHD",pm.getbaseLocation());
	    }

}


