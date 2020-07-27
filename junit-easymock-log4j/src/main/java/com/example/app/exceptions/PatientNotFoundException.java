package com.example.app.exceptions;

public class PatientNotFoundException extends MyAppException{

	private static final long serialVersionUID = 1L;

	public PatientNotFoundException() {
		super();
	}

	public PatientNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PatientNotFoundException(String message) {
		super(message);
	}
	

}
