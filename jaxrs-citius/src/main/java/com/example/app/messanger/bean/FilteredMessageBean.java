package com.example.app.messanger.bean;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class FilteredMessageBean {
	@QueryParam("year")
	@DefaultValue(value = "-1")
	private int year;
	@DefaultValue(value = "-1")
	@QueryParam("start")
	private int start;
	@DefaultValue(value = "-1")
	@QueryParam("size")
	private int size;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	

}
