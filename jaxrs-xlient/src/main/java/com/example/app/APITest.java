package com.example.app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class APITest {
	private static final String API="http://localhost:8084/jaxrs-citius/api/messages";
	public static void main(String[] args) {
		Client client = null;
		try {
			client=ClientBuilder.newClient();
		
		
     Response response=		client.target(API).request().get();
     System.out.println(response.getEntity());
     }
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if(client!=null)
			client.close();
			
		}
		
		
     
	}

}
