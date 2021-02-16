package com.RestAssured_AutomationFramework_baseclass;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testbase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public static String empID = "24";

	public Logger logger;

	
	@BeforeClass
	public void setUp() {

		logger = Logger.getLogger("*** Employee Rest API Automation Framework ***");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
}
