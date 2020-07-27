package com.example.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.app.dao.H2DBDao;
import com.example.app.entity.Patient;
import com.example.app.exceptions.PatientNotFoundException;

public class MyServiceTest {
	private static MyService service=null;

	@BeforeClass
	public static void init() {
		
		List<String> excepctedNames = new ArrayList<String>();
		excepctedNames.add("John");
		excepctedNames.add("Smith");
		excepctedNames.add("Peter");
		
		// setting up proxy
		H2DBDao mockdao = EasyMock.createMock(H2DBDao.class);

		
		//setting behaviour for testGetNameById_01()
		EasyMock.expect(mockdao.findNamebyId(101)).andReturn("temp");
		EasyMock.expect(mockdao.findNamebyId(109)).andReturn("pent");
		
		//setting behaviour for testgetAllContactNames_01
		EasyMock.expect(mockdao.findAllNames()).andReturn(excepctedNames);

		//setting behaviour for testgetPatientById_01
		EasyMock.expect(mockdao.getPatientId(1)).andReturn(new Patient(1, "Motu", 9889L, "test@gmail.com"));
		
		//setting behaviour for testgetPatientByIdException_02()
		EasyMock.expect(mockdao.getPatientId(2)).andReturn(null);
		
		EasyMock.replay(mockdao);
		
		service = new MyServiceImpl(mockdao);

	}

	@Test
	@Ignore
	public void testGetNameById_01() {
		String actual1 = service.getNameWithUpperById(101);
		String excepted1 = "TEMP";
		String excepted2 = "PENT";
		assertEquals(excepted1, actual1);
	}

	@Test()@Ignore
	public void testgetAllContactNames_01() {
		List<String> actualNames = service.getAllContactNames();
		 assertNotNull("Names shouldn't be null", actualNames);
	}
	
	@Test()@Ignore
	public void testgetPatientById_01() {
		Patient acualtPatient= service.getPatientById(1);
		/// assertNotNull("Patient shouldn't be null", acualtPatient);
		assertEquals(acualtPatient, new Patient(1, "Motu", 9889L, "test@gmail.com"));
	}
	@Test( expected = PatientNotFoundException.class)
	public void testgetPatientByIdException_02() {
		Patient acualtPatient= service.getPatientById(2);
		/// assertNotNull("Patient shouldn't be null", acualtPatient);
	}

	@AfterClass
	public  static void tearDown() {
		System.out.println("Cleaned");

	}
}
