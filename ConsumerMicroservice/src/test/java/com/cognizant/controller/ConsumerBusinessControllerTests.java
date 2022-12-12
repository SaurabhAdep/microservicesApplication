package com.cognizant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.payload.ConsumerBusinessRequest;
import com.cognizant.payload.ConsumerBusinessResponse;
import com.cognizant.proxy.AuthClient;
import com.cognizant.repository.BusinessRepository;
import com.cognizant.repository.ConsumerRepository;
import com.cognizant.repository.PropertyRepository;
import com.cognizant.service.ConsumerBusinessServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
class ConsumerBusinessControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private ConsumerBusinessServiceImpl consumerBusinessService;
	@MockBean
	private BusinessRepository businessRepository;
	@MockBean
	private ConsumerRepository consumerRepository;
	@MockBean
	private PropertyRepository propertyRepository;
	@MockBean
	private AuthClient authClient;

	
	@Test

	 void getConsumerBusiness() throws Exception {
		ConsumerBusinessResponse mockConsumerBusinessDetails=new ConsumerBusinessResponse((long)1,"saurabh","adep",new SimpleDateFormat("dd/MM/yyyy").parse("05/06/2000"),"bname","pan","email","phone","website","bo","validity","aname",(long)1,(long)1,"bcat","btype",(long)12,(long)13,(long)4,(long)15,(long)11);
		Mockito.when(consumerBusinessService.viewConsumerBusiness(Mockito.anyLong())).thenReturn(mockConsumerBusinessDetails);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/viewConsumerBusiness?consumerId=1").header("Authorization", "Bearer Token").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		
		
		String expected=result.getResponse().getContentAsString();
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	
	@Test
	
	 void createConsumerBusiness() throws Exception {
		String messageResponse ="{\"message\":\"SuccessFully Created Consumer with Consumer ID 1and Business ID 1.Thank you!\"}";
		String exampleCourseJson = "{\"consumerId\":\"1\",\"agentID\": \"1\",\"agentName\": \"sankit\",\"businessAge\": \"3\",\"businessCategory\": \"Consultant\",\"businessName\": \"SankitConsultant\",\"businessOverview\": \"SankitConsultant\",\"businessTurnover\": \"15\",\"businessType\": \"Service Business\",\"capitalInvested\": \"1\",\"dob\": \"2000-10-10\",\"email\": \"akshitchandora9812@gmail.com\",\"firstName\": \"Akshit\",\"lastName\": \"Kumar\",\"panDetails\": \"BHYOC2000F\",\"phone\": \"9915560741\",\"totalEmployees\": \"75\",\"validity\": \"1 year\",\"website\": \"akshit.com\"}";
		Mockito.when(consumerBusinessService.createConsumerBusiness(Mockito.any(ConsumerBusinessRequest.class))).thenReturn(messageResponse);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createConsumerBusiness").header("Authorization", "Bearer Token").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expected="{\"message\":\"SuccessFully Created Consumer with Consumer ID 1and Business ID 1.Thank you!\"}";
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	@Test
	
	 void updateConsumerBusiness() throws Exception {
		String messageResponse ="{\"message\":\"SuccessFully Updated Consumer with Consumer ID 1and Business ID 1.Thank you!\"}";
		String exampleCourseJson = "{\"consumerId\":\"1\",\"agentID\": \"1\",\"agentName\": \"sankit\",\"businessAge\": \"3\",\"businessCategory\": \"Consultant\",\"businessName\": \"SankitConsultant\",\"businessOverview\": \"SankitConsultant\",\"businessTurnover\": \"15\",\"businessType\": \"Service Business\",\"capitalInvested\": \"1\",\"dob\": \"2000-10-10\",\"email\": \"akshitchandora9812@gmail.com\",\"firstName\": \"Akshit\",\"lastName\": \"Kumar\",\"panDetails\": \"BHYOC2000F\",\"phone\": \"9915560741\",\"totalEmployees\": \"75\",\"validity\": \"1 year\",\"website\": \"akshit.com\"}";
		Mockito.when(consumerBusinessService.updateConsumerBusiness(Mockito.any(ConsumerBusinessRequest.class))).thenReturn(messageResponse);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateConsumerBusiness").header("Authorization", "Bearer Token").accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		String expected="{\"message\":\"SuccessFully Updated Consumer with Consumer ID 1and Business ID 1.Thank you!\"}";
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(expected, result.getResponse().getContentAsString());
	}
	
	
	
	
	

}