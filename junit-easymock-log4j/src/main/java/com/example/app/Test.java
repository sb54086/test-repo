package com.example.app;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;

public class Test {

	private static Logger logger = Logger.getLogger(Test.class);
	static {
		//Layout layout = new SimpleLayout();
		//Layout layout = new HTMLLayout();
		//Layout layout = new XMLLayout();
		//Layout layout = new PatternLayout("%p %d %C %M-%L %m %n");
		//Layout layout = new PatternLayout("%L %l  %m %n");
		Layout layout = new PatternLayout("%d{dd-MM-yy hh:mm:ss} %p --- [%M]: %C %L %m %n");
		
		//Layout layout = new PatternLayout("");
		
		Appender appender = new ConsoleAppender(layout);
		logger.addAppender(appender);
		
		
		/*
		 * try { Appender appender = new FileAppender(layout,
		 * "C:\\Workspace\\EclipseWP\\junit-easymock\\src\\logs\\mylog.log");
		 * logger.addAppender(appender); } catch (IOException e) { e.printStackTrace();
		 * }
		 */
		
	}
	public static void main(String[] args) {
    logger.info("MEsgae");
    logger.debug("Debugging");
    logger.error("Error");
    logger.warn("Warmning");
    logger.fatal("Fatal ");
    
	}

}
