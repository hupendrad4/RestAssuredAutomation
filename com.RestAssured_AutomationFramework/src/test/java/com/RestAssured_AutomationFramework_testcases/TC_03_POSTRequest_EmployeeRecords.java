package com.RestAssured_AutomationFramework_testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured_AutomationFramework_baseclass.Testbase;
import com.RestAssured_AutomationFramework_utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_03_POSTRequest_EmployeeRecords extends Testbase {

	RequestSpecification httprequest;
	Response response;

	String employeeName = RestUtils.empName();
	String employeeAge = RestUtils.empAge();
	String employeeSal = RestUtils.empSal();

	@BeforeClass
	void create_Employee() throws InterruptedException {

		logger.info("*** Starting TC_03_POSTRequest_EmployeeRecords *** ");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		requestParam.put("name", employeeName);
		requestParam.put("age", employeeAge);
		requestParam.put("salary", employeeSal);

		httprequest.header("Content-Type", "application/json");

		// add json to body of request
		httprequest.body(requestParam.toJSONString());

		response = httprequest.request(Method.POST, "/create");
		Thread.sleep(3000);

		

	}

	@Test
	void checkResponseBody() {

		logger.info("*checking Response body *");
		String response_body = response.getBody().asString();
		System.out.println("The Response body is :" + response_body);
		Assert.assertEquals(response_body.contains(employeeName), true);
		Assert.assertEquals(response_body.contains(employeeAge), true);
		Assert.assertEquals(response_body.contains(employeeSal), true);
		logger.info("*Validated Response body *");
	}

	@Test
	void checkStatusCode() {
		logger.info("*checking Status code *");
		int status_code = response.getStatusCode();
		logger.info("The Status code is:" + status_code);
		Assert.assertEquals(status_code, 200);
		logger.info("* Validated Status code *");

	}

	@Test
	void checkStatusLine() {
		logger.info("*checking Status Line *");
		String status_line = response.getStatusLine();
		logger.info("The Status line info: " + status_line);
		logger.info("*Validated Status Line Successfully*");
	}

	@Test
	void checkServerType() {
		logger.info(" * checking Server type *");
		String server_type = response.header("Server");
		Assert.assertEquals(server_type, "nginx/1.16.0");
		logger.info("* Validated Server type Successfully *");
	}

	@Test
	void checkContentType() {

		logger.info(" * Checking The Content Type ");
		String content_type = response.header("Content-Type");
		Assert.assertEquals(content_type, "application/json");
		logger.info("* Validated Content Type Successfully *");

	}

	@Test
	void checkContentEncodingType() {
		logger.info(" * Checking Content Encoding type *");
		String content_length = response.header("* Checking Content encoding type *");
		System.out.println("The Content encoding type :" + content_length);
		Assert.assertEquals(content_length, "gzip");
		logger.info("* validated Content Encoding type *");
	}

	@Test
	void checkContentLength() {
		logger.info("* Checking Content-Length ");
		String content_length = response.header("Content-Length");
		System.out.println("The content length :" + content_length);
		Assert.assertEquals(content_length, "136");
		logger.info("* Validated  Content-Length *");
	}

	@Test
	void tearDown() {
		
		logger.info("*** End of TC_03_POSTRequest_EmployeeRecords execution *** ");

	}

}
