package com.cognizant.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.payload.BusinessPropertyResponse;


@ExtendWith(MockitoExtension.class)
 class BusinessPropertyRequestTests {
	
	BusinessPropertyResponse businessPropertyRequest;

	
	@Test
     void testBusinessPropertyRequest() throws Exception {
		businessPropertyRequest=new BusinessPropertyResponse();
		businessPropertyRequest.setBuildingAge((long)1);
		businessPropertyRequest.setBuildingSqft("buildingsqft");
		businessPropertyRequest.setBuildingStoreys("buildingstoreys");
		businessPropertyRequest.setBuildingType("buildingtype");
		businessPropertyRequest.setConsumerId((long)1);
		businessPropertyRequest.setCostOfTheAsset((long)1);
		businessPropertyRequest.setInsuranceType("insurancetype");
		businessPropertyRequest.setPropertyType("propertytype");
		businessPropertyRequest.setSalvageValue((long)1);
		businessPropertyRequest.setUsefulLifeOfTheAsset((long)1);
		assertEquals((long)1,businessPropertyRequest.getBuildingAge());
		assertEquals("buildingsqft",businessPropertyRequest.getBuildingSqft());
		assertEquals("buildingstoreys",businessPropertyRequest.getBuildingStoreys());
		assertEquals("buildingtype",businessPropertyRequest.getBuildingType());
		assertEquals((long)1,businessPropertyRequest.getConsumerId());
		assertEquals((long)1,businessPropertyRequest.getCostOfTheAsset());
		assertEquals("insurancetype",businessPropertyRequest.getInsuranceType());
		assertEquals("propertytype",businessPropertyRequest.getPropertyType());
		assertEquals((long)1,businessPropertyRequest.getSalvageValue());
		assertEquals((long)1,businessPropertyRequest.getUsefulLifeOfTheAsset());
	}
	
	@Test
     void testBusinessPropertyRequestConstructor() throws Exception {
		businessPropertyRequest=new BusinessPropertyResponse((long)1,(long)1,"test","test","test","test","test",(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,businessPropertyRequest.getBuildingAge());
		assertEquals("test",businessPropertyRequest.getBuildingSqft());
		assertEquals("test",businessPropertyRequest.getBuildingStoreys());
		assertEquals("test",businessPropertyRequest.getBuildingType());
		assertEquals((long)1,businessPropertyRequest.getConsumerId());
		assertEquals((long)1,businessPropertyRequest.getCostOfTheAsset());
		assertEquals("test",businessPropertyRequest.getInsuranceType());
		assertEquals("test",businessPropertyRequest.getPropertyType());
		assertEquals((long)1,businessPropertyRequest.getSalvageValue());
		assertEquals((long)1,businessPropertyRequest.getUsefulLifeOfTheAsset());
	}
	

}
