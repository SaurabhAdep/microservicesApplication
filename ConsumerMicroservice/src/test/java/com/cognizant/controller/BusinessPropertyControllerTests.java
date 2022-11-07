package com.cognizant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.model.Property;
import com.cognizant.payload.BusinessPropertyRequest;
import com.cognizant.proxy.AuthClient;
import com.cognizant.repository.BusinessRepository;
import com.cognizant.repository.ConsumerRepository;
import com.cognizant.repository.PropertyRepository;
import com.cognizant.service.ConsumerPropertyServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
class BusinessPropertyControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	private static final String IT="Invalid token";
	
	private static final String CDEBUG="consumer : {}";
	
	
	@MockBean
	private ConsumerPropertyServiceImpl consumerPropertyService;
	@MockBean
	private BusinessRepository businessRepository;
	@MockBean
	private ConsumerRepository consumerRepository;
	@MockBean
	private PropertyRepository propertyRepository;
	@MockBean
	private AuthClient authClient;


	
	@Test
	void getConsumerProperty() throws Exception {
		Property property=new Property((long) 1,"Fire","Building","string","Owner","string",(long)1,(long)10000,(long)10000,(long)5000,(long)50);
		Mockito.when(consumerPropertyService.viewConsumerProperty(Mockito.anyLong(),Mockito.anyLong())).thenReturn(property);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		
		MvcResult result=mockMvc.perform(get("/viewConsumerProperty?consumerId=1&propertyId=1").header("Authorization", "Bearer Token").contentType(MediaType.APPLICATION_JSON)).andReturn();
		String expected="{\"id\":1,\"insuranceType\":\"Fire\",\"propertyType\":\"Building\",\"buildingSqft\":\"string\",\"buildingType\":\"Owner\",\"buildingStoreys\":\"string\",\"buildingAge\":1,\"propertyValue\":10000,\"costOfTheAsset\":10000,\"salvageValue\":5000,\"usefulLifeOfTheAsset\":50}";
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	

	
	@Test
	 void createBusinessProperty() throws Exception {
		String messageResponse ="{\"message\":\"SuccessFully Created Business Property with Property Id 1.Thank you!\"}";
		String ExampleJson = "{\"id\":1,\"buildingAge\": 2,\"buildingSqft\": \"string\",\"buildingStoreys\": \"string\",\"buildingType\": \"Owner\",\"consumerId\": 1,\"costOfTheAsset\": 5,\"insuranceType\": \"Fire\",\"propertyType\": \"Building\",\"salvageValue\": 1,\"usefulLifeOfTheAsset\": 1}";
		Mockito.when(consumerPropertyService.createBusinessProperty(Mockito.any(BusinessPropertyRequest.class))).thenReturn(messageResponse);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createBusinessProperty").header("Authorization", "Bearer Token").accept(MediaType.APPLICATION_JSON).content(ExampleJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expected="{\"message\":\"SuccessFully Created Business Property with Property Id 1.Thank you!\"}";
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	@Test
	 void updateBusinessProperty() throws Exception {
		String messageResponse ="{\"message\":\"SuccessFully Updated Business Property with Property Id 1.Thank you!\"}";
		String ExampleJson = "{\"id\":1,\"buildingAge\": 2,\"buildingSqft\": \"string\",\"buildingStoreys\": \"string\",\"buildingType\": \"Owner\",\"consumerId\": 1,\"costOfTheAsset\": 5,\"insuranceType\": \"Fire\",\"propertyType\": \"Building\",\"salvageValue\": 1,\"usefulLifeOfTheAsset\": 1}";
		Mockito.when(consumerPropertyService.updateBusinessProperty(Mockito.any(BusinessPropertyRequest.class))).thenReturn(messageResponse);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateBusinessProperty").header("Authorization", "Bearer Token").accept(MediaType.APPLICATION_JSON).content(ExampleJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expected="{\"message\":\"SuccessFully Updated Business Property with Property Id 1.Thank you!\"}";
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	
	
	

}