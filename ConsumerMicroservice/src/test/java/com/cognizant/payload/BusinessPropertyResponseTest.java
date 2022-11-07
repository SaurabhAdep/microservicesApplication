package com.cognizant.payload;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BusinessPropertyResponseTest {
	private BusinessPropertyResponse businessPropertyResponse;
	

	@Test
	public void toStringTest() {
	businessPropertyResponse = new BusinessPropertyResponse((long)1,(long)1,"Burglary","Building","100 sq ft","Commercial","Four",(long)2,(long)3,(long)2,(long)2);
	String string  = businessPropertyResponse.toString();
	assertEquals(string, businessPropertyResponse.toString());
	}
	
	
}
