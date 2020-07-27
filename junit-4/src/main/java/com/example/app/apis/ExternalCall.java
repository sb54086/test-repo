package com.example.app.apis;

public class ExternalCall {
	AWSApi api;
	
	
	public ExternalCall(AWSApi api) {
		super();
		this.api = api;
	}


	public String findApiData() {
		String resp=null;
		
		resp=api.getResponse();
		return resp+resp;
	}
	

}
