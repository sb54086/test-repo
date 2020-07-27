package com.example.app.service;

public class MyService {
	CalculatorService service;

	public MyService(CalculatorService service) {
		super();
		this.service = service;
	}
	
	public int perfom(int i,int j) {
		return service.add(i, j);
		//return (i+j);
	}
	

}
