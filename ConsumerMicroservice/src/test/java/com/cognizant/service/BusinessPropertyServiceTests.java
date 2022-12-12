package com.cognizant.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;




@ExtendWith(MockitoExtension.class)
 class BusinessPropertyServiceTests {
	
	@InjectMocks
	private  ConsumerPropertyServiceImpl consumerPropertyService;
	
	
	@Test
     void testCalculatePropertyValue() throws Exception {
		long res=consumerPropertyService.calPropertyValue((long)200,(long)20,(long)13);
		assertEquals((long)9, res);
    }
	@Test
	public void testCalculattePropertyValue() throws Exception{
		
		assertThrows(NullPointerException.class ,()-> consumerPropertyService.calPropertyValue((long)0,(long)20,(long)13) );
		

	}
	@Test
	public void testCalculatteProperttyValue() throws Exception{
		
		assertThrows(NullPointerException.class ,()-> consumerPropertyService.calPropertyValue((long)20,(long)0,(long)13) );
		

	}
	@Test
	public void testCallculatteProperttyValue() throws Exception{
		
		assertThrows(NullPointerException.class ,()-> consumerPropertyService.calPropertyValue((long)20,(long)10,(long)0) );
		

	}
	
	@Test
	public void testtCalculattePropertyValue() throws Exception{
		
		assertThrows(NullPointerException.class ,()-> consumerPropertyService.calPropertyValue((long)10,(long)10,(long)20) );
		

	}
	
	


}
