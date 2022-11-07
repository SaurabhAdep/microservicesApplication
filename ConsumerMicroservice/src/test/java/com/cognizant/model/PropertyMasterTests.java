package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
 class PropertyMasterTests {
	
	private PropertyMaster property;
	
	
	@Test
     void testPropertyMasterDetails() throws Exception {
		property=new PropertyMaster();
		property.setBuildingAge((long)1);
		property.setBuildingType("type");
		property.setId((long)1);
		property.setInsuranceType("itype");
		property.setPropertyType("ptype");
		assertEquals((long)1,property.getBuildingAge());
		assertEquals("type",property.getBuildingType());
		assertEquals((long)1,property.getId());
		assertEquals("itype",property.getInsuranceType());
		assertEquals("ptype",property.getPropertyType());
	}
	
	@Test
     void testPropertyMasterConstructor() throws Exception {
		property=new PropertyMaster((long)1,"itype","ptype","type",(long)1);
		assertEquals((long)1,property.getBuildingAge());
		assertEquals("type",property.getBuildingType());
		assertEquals((long)1,property.getId());
		assertEquals("itype",property.getInsuranceType());
		assertEquals("ptype",property.getPropertyType());
	}
	@Test
	public void toStringTest() throws Exception {
		property=new PropertyMaster((long)1,"itype","ptype","type",(long)1);
		    String string  = property.toString();
		assertEquals(string, property.toString());
	}
}
