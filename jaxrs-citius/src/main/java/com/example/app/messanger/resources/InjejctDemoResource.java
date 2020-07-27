package com.example.app.messanger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjejctDemoResource {

	@GET
	@Path("annotaions")
	public String getAllParamsUsingAnnotaions(@MatrixParam("mp")String mp
			,@HeaderParam("h1")String hp1,@CookieParam("c1")String ck1) {
		//http://localhost:8084/jaxrs-citius/api/injectdemo/annotaions;mp=value
		return "Matrix Param: "+mp+"  Header Param: "+hp1+"  Cookie Param"+ck1;
	}



	@GET
	@Path("context")
	public String getAllParamsUsingContext(@Context()UriInfo info,
			@Context HttpHeaders headers) {
		return info.getAbsolutePath().toString()+headers.getHeaderString("h1");
	}
	

}
