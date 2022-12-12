package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
 class BusinessTests {
	
	private Business business;
	
    
	@Test
     void testBusinessDetails() throws Exception {
		business=new Business();
	    business.setBusinessAge((long)11);
	    business.setBusinessCategory("category");
	    business.setBusinessTurnover((long)10);
	    business.setBusinessType("type");
	    business.setBusinessValue((long)500);
	    business.setCapitalInvested((long)200);
	    business.setId((long)1);
	    business.setTotalEmployees((long)10);
        assertEquals((long)11,business.getBusinessAge());
        assertEquals("category",business.getBusinessCategory());
        assertEquals((long)10,business.getBusinessTurnover() );
        assertEquals("type",business.getBusinessType() );
        assertEquals((long)500,business.getBusinessValue() );
        assertEquals((long)200,business.getCapitalInvested() );
        assertEquals((long)1,business.getId() );
        assertEquals((long)10,business.getTotalEmployees());

    }
	
	@Test
     void testBusinessAllArgsConstructor() throws Exception {
		business=new Business((long)1,"category","type",(long)1,(long)1,(long)1,(long)1,(long)1);
		
        assertEquals((long)1,business.getBusinessAge());
        assertEquals("category",business.getBusinessCategory());
        assertEquals((long)1,business.getBusinessTurnover() );
        assertEquals("type",business.getBusinessType() );
        assertEquals((long)1,business.getBusinessValue() );
        assertEquals((long)1,business.getCapitalInvested() );
        assertEquals((long)1,business.getId() );
        assertEquals((long)1,business.getTotalEmployees());

    }
	
	@Test
     void testBusinessArgsController() throws Exception {
		business=new Business((long)1,"category","type",(long)1,(long)1,(long)1,(long)1,(long)1);
        assertEquals((long)1,business.getBusinessAge());
        assertEquals("category",business.getBusinessCategory());
        assertEquals((long)1,business.getBusinessTurnover() );
        assertEquals("type",business.getBusinessType() );
        assertEquals((long)1,business.getBusinessValue() );
        assertEquals((long)1,business.getCapitalInvested() );
        assertEquals((long)1,business.getTotalEmployees());
        assertEquals((long)1, business.getId());

    }
	@Test
	public void toStringTest() throws Exception {
		business=new Business((long)1,"category","type",(long)1,(long)1,(long)1,(long)1,(long)1);
	       String string  = business.toString();
		assertEquals(string, business.toString());
	}

}
