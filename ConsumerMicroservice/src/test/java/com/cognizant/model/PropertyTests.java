package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
 class PropertyTests {
	
	private Property property;
	
	
	@Test
     void testPropertyDetails() throws Exception {
		property=new Property();
		property.setBuildingAge((long)1);
		property.setBuildingSqft("sqft");
		property.setBuildingStoreys("storeys");
		property.setBuildingType("type");
		property.setCostOfTheAsset((long)10);
		property.setId((long)1);
		property.setInsuranceType("itype");
		property.setPropertyType("ptype");
		property.setPropertyValue((long)100);
		property.setSalvageValue((long)10);
		property.setUsefulLifeOfTheAsset((long)5);
		assertEquals((long)1,property.getBuildingAge());
		assertEquals("sqft",property.getBuildingSqft());
		assertEquals("storeys",property.getBuildingStoreys());
		assertEquals("type",property.getBuildingType());
		assertEquals((long)10,property.getCostOfTheAsset());
		assertEquals((long)1,property.getId());
		assertEquals("itype",property.getInsuranceType());
		assertEquals("ptype",property.getPropertyType());
		assertEquals((long)100,property.getPropertyValue());
		assertEquals((long)10,property.getSalvageValue());
		assertEquals((long)5,property.getUsefulLifeOfTheAsset());
	}
	
	@Test
     void testPropertyAllArgsConstructor() throws Exception {
		property=new Property((long)1,"test","test","test","test","test",(long)1,(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,property.getBuildingAge());
		assertEquals("test",property.getBuildingSqft());
		assertEquals("test",property.getBuildingStoreys());
		assertEquals("test",property.getBuildingType());
		assertEquals((long)1,property.getCostOfTheAsset());
		assertEquals((long)1,property.getId());
		assertEquals("test",property.getInsuranceType());
		assertEquals("test",property.getPropertyType());
		assertEquals((long)1,property.getPropertyValue());
		assertEquals((long)1,property.getSalvageValue());
		assertEquals((long)1,property.getUsefulLifeOfTheAsset());
	}
	@Test
     void testPropertyArgsConstructor() throws Exception {
		property=new Property((long)1,"test","test","test","test","test",(long)1,(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,property.getBuildingAge());
		assertEquals("test",property.getBuildingSqft());
		assertEquals("test",property.getBuildingStoreys());
		assertEquals("test",property.getBuildingType());
		assertEquals((long)1,property.getCostOfTheAsset());
		assertEquals("test",property.getInsuranceType());
		assertEquals("test",property.getPropertyType());
		assertEquals((long)1,property.getPropertyValue());
		assertEquals((long)1,property.getSalvageValue());
		assertEquals((long)1,property.getUsefulLifeOfTheAsset());
	}

}
