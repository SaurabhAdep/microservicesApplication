package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
 class BusinessMasterTests {
	
private BusinessMaster business;
	
	
	@Test
     void testBusinessMasterDetails() throws Exception {
		business=new BusinessMaster();
		business.setBusinessAge((long)10);
		business.setBusinessCategory("category");
		business.setBusinessType("type");
		business.setId((long)1);
		business.setTotalEmployees((long)10);
		assertEquals((long)10,business.getBusinessAge());
		assertEquals("category",business.getBusinessCategory());
		assertEquals("type",business.getBusinessType());
		assertEquals((long)1,business.getId());
		assertEquals((long)10,business.getTotalEmployees());
		
	}
	
	@Test
     void testBusinessMasterConstructor() throws Exception {
		business=new BusinessMaster((long)1,"category","type",(long)1,(long)1);
		assertEquals((long)1,business.getBusinessAge());
		assertEquals("category",business.getBusinessCategory());
		assertEquals("type",business.getBusinessType());
		assertEquals((long)1,business.getId());
		assertEquals((long)1,business.getTotalEmployees());
		
	}
	@Test
	public void toStringTest() throws Exception {
		business=new BusinessMaster((long)1,"category","type",(long)1,(long)1);
		    String string  = business.toString();
		assertEquals(string, business.toString());
	}


}
