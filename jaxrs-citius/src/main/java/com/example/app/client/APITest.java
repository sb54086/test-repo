package com.example.app.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.example.app.messanger.model.Message;

public class APITest {
	private static final String API="http://localhost:8084/jaxrs-citius/api/messages";
	public static void main(String[] args) {
		Client client = null;
		try {
			client=ClientBuilder.newClient();
		
		
     Response response=		client.target(API).request().get();
     System.out.println(response.readEntity(Message.class).getMessage());
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
