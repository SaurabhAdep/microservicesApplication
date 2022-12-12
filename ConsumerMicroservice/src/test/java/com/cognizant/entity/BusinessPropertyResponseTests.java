package com.cognizant.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.payload.BusinessPropertyResponse;


@ExtendWith(MockitoExtension.class)
 class BusinessPropertyResponseTests {
	
	BusinessPropertyResponse businessPropertyDetails;
	
	
	@Test
     void testBusinessPropertyDetails() throws Exception {
		businessPropertyDetails=new BusinessPropertyResponse();
		businessPropertyDetails.setBuildingAge((long)1);
		businessPropertyDetails.setBuildingSqft("buildingsqft");
		businessPropertyDetails.setBuildingStoreys("buildingstoreys");
		businessPropertyDetails.setBuildingType("buildingtype");
		businessPropertyDetails.setConsumerId((long)1);
		businessPropertyDetails.setCostOfTheAsset((long)1);
		businessPropertyDetails.setInsuranceType("insurancetype");
		businessPropertyDetails.setId((long)1);
		businessPropertyDetails.setPropertyType("propertytype");
		businessPropertyDetails.setSalvageValue((long)1);
		businessPropertyDetails.setUsefulLifeOfTheAsset((long)1);
		assertEquals((long)1,businessPropertyDetails.getBuildingAge());
		assertEquals("buildingsqft",businessPropertyDetails.getBuildingSqft());
		assertEquals("buildingstoreys",businessPropertyDetails.getBuildingStoreys());
		assertEquals("buildingtype",businessPropertyDetails.getBuildingType());
		assertEquals((long)1,businessPropertyDetails.getConsumerId());
		assertEquals((long)1,businessPropertyDetails.getCostOfTheAsset());
		assertEquals("insurancetype",businessPropertyDetails.getInsuranceType());
		assertEquals((long)1,businessPropertyDetails.getId());
		assertEquals("propertytype",businessPropertyDetails.getPropertyType());
		assertEquals((long)1,businessPropertyDetails.getSalvageValue());
		assertEquals((long)1,businessPropertyDetails.getUsefulLifeOfTheAsset());
	}
	
	@Test
     void testBusinessPropertyDetailsConstructor() throws Exception {
		businessPropertyDetails=new BusinessPropertyResponse((long)1,(long)1,"test","test","test","test","test",(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,businessPropertyDetails.getBuildingAge());
		assertEquals("test",businessPropertyDetails.getBuildingSqft());
		assertEquals("test",businessPropertyDetails.getBuildingStoreys());
		assertEquals("test",businessPropertyDetails.getBuildingType());
		assertEquals((long)1,businessPropertyDetails.getConsumerId());
		assertEquals((long)1,businessPropertyDetails.getCostOfTheAsset());
		assertEquals("test",businessPropertyDetails.getInsuranceType());
		assertEquals((long)1,businessPropertyDetails.getId());
		assertEquals("test",businessPropertyDetails.getPropertyType());
		assertEquals((long)1,businessPropertyDetails.getSalvageValue());
		assertEquals((long)1,businessPropertyDetails.getUsefulLifeOfTheAsset());
	}

}
