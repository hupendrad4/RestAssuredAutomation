package com.RestAssured_AutomationFramework_testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.logging.Logger;

import com.RestAssured_AutomationFramework_baseclass.Testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_01_GETRequest_AllEmployees extends Testbase {

	@BeforeClass
	public void getAllEmp() throws InterruptedException {

		logger.info("*** TC_01_GETRequest_AllEmployees ***");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		Thread.sleep(3000);
	}

	@Test
	public void checkResponseBody() {
		logger.info("*** Checking Response Body ***");
		String response_body = response.getBody().asString();
		logger.info("Response Body is :" + response_body);
		Assert.assertTrue(response_body != null);

	}

	@Test
	public void checkStatusCode() {
		logger.info("*** Checking Status Code ***");
		int status_code = response.getStatusCode();
		logger.info("The Status Code is :" + status_code);
		Assert.assertEquals(status_code, 200);

	}

	@Test
	public void checkResponseTime() {
		logger.info("*** Checking Response Time ***");
		long response_time = response.getTime();
		logger.info("The Response time is :" + response_time);

		if (response_time > 2000) {
			logger.warn("The Response time is taking more than 2000");
			Assert.assertTrue(response_time > 2000);
		}
	}

	@Test
	public void checkStatusLine() {
		logger.info("*** Checking Status Line ***");

		String status_line = response.getStatusLine();
		logger.info("The Status line is :" + status_line);
		Assert.assertEquals(status_line, "HTTP/1.1 200 OK");

	}

	@Test
	public void checkContentType() {
		logger.info("*** Checking Content Type***");
		String content_type = response.header("Content-Type");
		logger.info("The Content Type is :" + content_type);
		Assert.assertEquals(content_type, "application/json;charset=utf-8");

	}

	@Test
	public void checkServerType() {
		logger.info("*** Checking Server Type***");
		String server_type = response.header("Server");
		logger.info("The Server Type is :" + server_type);
		Assert.assertEquals(server_type, "nginx/1.16.0");

	}

	@Test
	public void checkContentEncoding() {
		logger.info("*** Checking Content Encoding Type***");
		String content_encoding = response.header("Content-Encoding ");
		logger.info("The Content Encoding Type is :" + content_encoding);
		Assert.assertEquals(content_encoding, "gzip");
	}

	@Test
	public void checkContentLength() {
		logger.info("*** Checking Content Lenght ***");
		String content_length = response.header("Content-Length");
		logger.info("The Content Lenghth is :" + content_length);

		if (Integer.parseInt(content_length) < 100) {
			logger.warn("The content length is less than 100");

			Assert.assertTrue(Integer.parseInt(content_length) < 100);
		}

	}

	@Test
	public void checkcookies() {
		logger.info("*** Checking Cookies details ***");
		String cookie = response.getCookie("PHPSESSID");

	}

	@AfterClass
	public void tearDown() {

		logger.info("*** TC_01_GETRequest_AllEmployees finish ***");
	}

}
