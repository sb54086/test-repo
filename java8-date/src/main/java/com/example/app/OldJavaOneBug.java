package com.example.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class OldJavaOneBug {
	public static void main(String[] args) {
		
	}
	static void b6ugtest() {
		Date date=new Date(2007,12,13,16,40);
		
		TimeZone zone=TimeZone.getTimeZone("Asia/HongKong");
		
		Calendar calendar=new GregorianCalendar(date,zone);
		DateFormat format=new SimpleDateFormat("HH:mm Z");
		String strDate=format.format(calendar);
		System.out.println("2007 Date: "+strDate);
	}
	static void b6ugtestSolved() {
		Date date=new Date(2007,12,13,16,40);
		
		TimeZone zone=TimeZone.getTimeZone("Asia/Hong_Kong");
		
		Calendar calendar=new GregorianCalendar(date,zone);
		DateFormat format=new SimpleDateFormat("HH:mm Z");
		String strDate=format.format(calendar);
		System.out.println("2007 Date: "+strDate);
	}

}
