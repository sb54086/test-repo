package com.example.app.service;

import java.util.List;

import com.example.app.dao.H2DBDao;
import com.example.app.entity.Patient;
import com.example.app.exceptions.PatientNotFoundException;

public class MyServiceImpl implements MyService {
	private H2DBDao dao;

	public MyServiceImpl(H2DBDao dao) {
		this.dao = dao;
	}

	@Override
	public String getNameWithUpperById(Integer id) {
		String name = dao.findNamebyId(id);
		System.out.println("Doing SOme Custome logic");
		return name.toUpperCase();
	}

	@Override
	public List<String> getAllContactNames() {
		List<String> names=dao.findAllNames();
	     if(!names.isEmpty()) {return names;}	
		return null;
	}

	@Override
	public Patient getPatientById(Integer id) {
		Patient patient=dao.getPatientId(id);
		if(patient==null) {
			throw new PatientNotFoundException("Patient Not Found for this ID");
		}
		
		return patient;
	}
	
	
	

}
