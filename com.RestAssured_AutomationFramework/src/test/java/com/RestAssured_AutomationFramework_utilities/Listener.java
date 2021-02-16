package com.RestAssured_AutomationFramework_utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onFinish(ITestContext testContext) {

		extent.flush();
	}

	@Override
	public void onStart(ITestContext testContext) {

		// This class representing the look and feel of the report.

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir"+"/Reports/ExtendReport.html"));
		htmlReporter.config().setDocumentTitle("RestAssuredExecutionReport");
		htmlReporter.config().setReportName("RestAssured");
		htmlReporter.config().setTheme(Theme.DARK);

		// This class sending common information to the report
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name", "Employee Data");
		extent.setSystemInfo("System Info", "Local User");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "HDeore");

		// extent Test class representing the pass and fail status to the report

	}

	
	@Override
	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName()); // Create new entry in the report
		test.log(Status.FAIL, "Test Case Failed is" + result.getName());
		test.log(Status.FAIL, "Test Case Failed is" + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName()); // Create new entry in the report
		test.log(Status.SKIP, "Test Case Skipped is" + result.getName());

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // Create new entry in the report
		test.log(Status.PASS, "Test Case Pass is" + result.getName());

	}
}