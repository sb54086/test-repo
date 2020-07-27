package com.example.app.messanger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/patient")
//@Api(value = "/patient",description = "For Patient Management Operations",tags = {"Patinet","All Patient"})
public class PatientResource {
	
	
	//@ApiOperation(value = "just for pinging",notes = "Importants for server availability",response = String.class)
	@Path(value = "/ping")
	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	public String ping() {
		return "pinged";
	}
	
	//@ApiOperation(value = "just for pinging2",notes = "Importants for server availability2",response = String.class)
	//@ApiResponses(value = {@ApiResponse(code = 400,message = "Found"),@ApiResponse(code = 404,message = "Not Found")})
	@Path(value = "/ping2")
	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	public String ping2() {
		return "pinged2";
	}

}
