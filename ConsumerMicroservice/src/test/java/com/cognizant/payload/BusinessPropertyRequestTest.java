package com.cognizant.payload;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BusinessPropertyRequestTest {
	private BusinessPropertyRequest businessPropertyRequest;
	
	@Test
    void testPropertyDetails() throws Exception {
	businessPropertyRequest = new BusinessPropertyRequest();
	businessPropertyRequest.setId((long)1);
	businessPropertyRequest.setConsumerId((long)1);
	businessPropertyRequest.setInsuranceType("Burglary");
	businessPropertyRequest.setPropertyType("Building");
	businessPropertyRequest.setBuildingSqft("100 sq ft");
	businessPropertyRequest.setBuildingType("Commercial");
	businessPropertyRequest.setBuildingStoreys("Four");
    businessPropertyRequest.setBuildingAge((long)2);
    businessPropertyRequest.setCostOfTheAsset((long)3);
    businessPropertyRequest.setSalvageValue((long)2);
    businessPropertyRequest.setUsefulLifeOfTheAsset((long)2);
    
    assertEquals((long)1,businessPropertyRequest.getId());
    assertEquals((long)1,businessPropertyRequest.getConsumerId());
    assertEquals("Burglary",businessPropertyRequest.getInsuranceType());
    assertEquals("Building",businessPropertyRequest.getPropertyType());
    assertEquals("100 sq ft",businessPropertyRequest.getBuildingSqft());
    assertEquals("Commercial",businessPropertyRequest.getBuildingType());
    assertEquals("Four",businessPropertyRequest.getBuildingStoreys());
    assertEquals((long)2,businessPropertyRequest.getBuildingAge());
    assertEquals((long)3,businessPropertyRequest.getCostOfTheAsset());
    assertEquals((long)2,businessPropertyRequest.getSalvageValue());
    assertEquals((long)2,businessPropertyRequest.getUsefulLifeOfTheAsset());
    }
	
	@Test
    void testPropertyAllArgsConstructor() throws Exception{
		businessPropertyRequest = new BusinessPropertyRequest((long)1,(long)1,"Burglary","Building","100 sq ft","Commercial","Four",(long)2,(long)3,(long)2,(long)2);
		
		assertEquals((long)1,businessPropertyRequest.getId());
	    assertEquals((long)1,businessPropertyRequest.getConsumerId());
	    assertEquals("Burglary",businessPropertyRequest.getInsuranceType());
	    assertEquals("Building",businessPropertyRequest.getPropertyType());
	    assertEquals("100 sq ft",businessPropertyRequest.getBuildingSqft());
	    assertEquals("Commercial",businessPropertyRequest.getBuildingType());
	    assertEquals("Four",businessPropertyRequest.getBuildingStoreys());
	    assertEquals((long)2,businessPropertyRequest.getBuildingAge());
	    assertEquals((long)3,businessPropertyRequest.getCostOfTheAsset());
	    assertEquals((long)2,businessPropertyRequest.getSalvageValue());
	    assertEquals((long)2,businessPropertyRequest.getUsefulLifeOfTheAsset());
	}
	
	
}
