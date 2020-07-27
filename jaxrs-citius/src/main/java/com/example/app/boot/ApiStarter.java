package com.example.app.boot;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(value = "api")
public class ApiStarter extends Application {

	Set<Object> singltons;

	public ApiStarter() {
	/*
	 * singltons = new HashSet<Object>(); singltons.add(new MessageResource());
	 * 
	 * BeanConfig beanConfig = new BeanConfig(); beanConfig.setVersion("1.0.2");
	 * beanConfig.setTitle("First JAX-RS with Swagger APplictaion");
	 * beanConfig.setSchemes(new String[] { "http" });
	 * beanConfig.setHost("localhost:8086"); beanConfig.setBasePath("/api");
	 * beanConfig.setResourcePackage("com.example.app.resources");
	 * beanConfig.setScan(true);
	 * 
	 * 
	 */
	}

	

}
