package com.cognizant.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ConsumerBusinessServiceTest {
	
	@InjectMocks
	private ConsumerBusinessServiceImpl consumerBusinessService;
	
	@Test
     void testCalculateBusinessValue() throws Exception {
		long res=consumerBusinessService.calBusinessValue((long)1,(long)2);
		assertEquals((long)15, res);
    }
	@Test
	public void testCalculatteBusinessValue() throws Exception{
		
		assertThrows(NullPointerException.class ,()-> consumerBusinessService.calBusinessValue((long)0,(long)2) );
		

	}
	@Test
	public void testtCalculatteBusinessValue() throws Exception{
		
		assertThrows(NullPointerException.class ,()-> consumerBusinessService.calBusinessValue((long)1,(long)0) );
		

	}
	@Test
	public void testCalculatteBusiinessValue() throws Exception{
		
		assertThrows(NullPointerException.class ,()-> consumerBusinessService.calBusinessValue((long)2,(long)2) );
		

	}

}
