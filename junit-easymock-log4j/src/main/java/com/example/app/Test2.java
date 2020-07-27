package com.example.app;

import org.apache.log4j.Logger;

public class Test2 {
	private static Logger logger = Logger.getLogger(Test2.class);
	public static void main(String[] args) {

		
		logger.info("MEsgae");
	    logger.debug("Debugging");
	    logger.error("Error");
	    logger.warn("Warmning");
	    logger.fatal("Fatal ");
	}

}
