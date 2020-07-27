package com.example.app.messanger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorModel {
	private String errorMessage;
	private int statusCode;
	private String documentaion;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDocumentaion() {
		return documentaion;
	}
	public void setDocumentaion(String documentaion) {
		this.documentaion = documentaion;
	}
	public ErrorModel(String errorMessage, int statusCode, String documentaion) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.documentaion = documentaion;
	}
	public ErrorModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
