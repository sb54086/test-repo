package com.example.app.exception;

import java.io.Serializable;

public class DemoAPPException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = -8940522650843349669L;

	public DemoAPPException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DemoAPPException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
