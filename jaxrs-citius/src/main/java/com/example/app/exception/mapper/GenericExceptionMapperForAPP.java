package com.example.app.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.app.messanger.model.ErrorModel;

//@Provider
public class GenericExceptionMapperForAPP implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorModel model=new ErrorModel("Server Down", 500, "No Lonk");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(model).build();
	}

}
