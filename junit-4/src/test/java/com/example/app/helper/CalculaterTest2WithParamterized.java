package com.example.app.helper;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculaterTest2WithParamterized {
	Calculator calculator;
	
	@Parameters
	public static List<String[]> populateData(){
		return Arrays.asList(new String()[]);
	}
	
	@Test
	public void testAddWithNegative() {
		//.........
		assertTrue(true);
	}

}
