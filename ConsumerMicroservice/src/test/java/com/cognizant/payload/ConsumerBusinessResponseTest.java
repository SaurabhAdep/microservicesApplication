package com.cognizant.payload;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class ConsumerBusinessResponseTest {
	
	private ConsumerBusinessResponse consumerBusinessResponse;
	
	@Test 
	void consumerBusinessResponsetest() throws Exception{
		 consumerBusinessResponse = new ConsumerBusinessResponse();
		 consumerBusinessResponse.setAgentID((long)1);
		assertEquals((long)1,consumerBusinessResponse.getAgentID());
	}

}
