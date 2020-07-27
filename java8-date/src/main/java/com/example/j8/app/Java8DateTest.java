package com.example.j8.app;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8DateTest {
	public static void main(String[] args) {
		System.out.println("M Birthday : "+LocalDate.of(1995, 04, 03));
		
		System.out.println("Get Sample Local Time : "+LocalTime.of(17,20));
		
		System.out.println("Get Date and time : "+LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		
		System.out.println("Get Only LocalDat from LocalDateTime:  "+LocalDateTime.now().toLocalDate());
		
		getDifferenceBetweenParisAndLondonTimeZone();
		//isTodayAfterTommorow();
		//getLastDayOfTheMonth();
		//testHowLongIsThisYearUntillNewYear();
		//testLastDayofMonthInYear();
		//testLastDayofMonthInYearInJava8Streams();
		testALlFormatts();
	}
	public static void getDifferenceBetweenParisAndLondonTimeZone() {
		ZonedDateTime parisZonedDateTime=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		ZonedDateTime londonZonedDateTime=ZonedDateTime.now(ZoneId.of("Europe/London"));
		System.out.println("Differnce between Paris and London "+(parisZonedDateTime.getHour()-londonZonedDateTime.getHour()));
	}
	public void java8ToInstanctMethodInDate() {
		
	}
	public static void isTodayAfterTommorow() {
		LocalDate today=LocalDate.now();
		LocalDate tomorrow=today.plusDays(1);
		
		System.out.println("IsTommorow is AfterToday "+tomorrow.isAfter(today));
	}
	public static void getLastDayOfTheMonth() {
		System.out.println("Get LastDay of Current Month : "+LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());
	}
	public static void testHowLongIsThisYearUntillNewYear() {
		LocalDate today=LocalDate.now();
		LocalDate longestDay=today.with(Month.DECEMBER);
		System.out.println("HowLongIsThisYearUntillNewYear  : "+Period.between(today, longestDay).getMonths());
		
		
	}
	public  static void testLastDayofMonthInYear() {
		Integer tempYear=365;
		List<DayOfWeek> list=new ArrayList<DayOfWeek>();
        for(Month m:Month.values()) {
        	LocalDate date=LocalDate.now().withDayOfYear(tempYear).with(m).with(TemporalAdjusters.lastDayOfMonth());
        	DayOfWeek dayOfWeek=date.getDayOfWeek();
        	list.add(dayOfWeek);
        }
        list.forEach(System.out::println);
        
        
		
	}
	public  static void testLastDayofMonthInYearInJava8Streams() {
		Integer tempYear=12;
		Stream.of(Month.values())
		.map((month)->{
			return LocalDate.now().withYear(tempYear).with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
		}).collect(Collectors.toList()).forEach(System.out::println);
        
        
		
	}
	public static void testALlFormatts() {
		System.out.println("ISO Formatters "+LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		System.out.println("ISO Formatters "+LocalDate.now().format(DateTimeFormatter.ofPattern("MM/DD/yyyy")));
		
		
	}
	public static void parseLocalDateString(String dateString) {
		System.out.println(LocalDate.parse(dateString));
	}

}
