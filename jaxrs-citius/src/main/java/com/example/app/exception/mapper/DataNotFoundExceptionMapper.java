package com.example.app.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.app.exception.DataNotFoundException;
import com.example.app.messanger.model.ErrorModel;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException e) {
		ErrorModel model=new ErrorModel(e.getMessage(), 404, "http://google.com/help");
		return Response.status(Status.NOT_FOUND).
				entity(model)
				.build();
	}
	

}
