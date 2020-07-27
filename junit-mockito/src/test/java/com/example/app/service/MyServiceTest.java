package com.example.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MyServiceTest {
	MyService myClass=null;
	// CalculatorService service=mock(CalculatorService.class);  or
	@Mock
	CalculatorService service;
	
	@Rule
	public MockitoRule rule=MockitoJUnit.rule(); //Mockito have intigration to other framework so we are telling that use Junit	
	@Before
	public void setup() {
		this.myClass=new MyService(service);
	}
	
	
	@Test
	public void testPerformWithPositive() {
		when(service.add(2, 3)).thenReturn(5); //For injectine a dummy logic to the dependent class
		assertEquals(myClass.perfom(2, 3), 5); //actully asseerting
		verify(service).add(2, 3);  //for Verifying whether myclass called to service or not
		
	}

}
