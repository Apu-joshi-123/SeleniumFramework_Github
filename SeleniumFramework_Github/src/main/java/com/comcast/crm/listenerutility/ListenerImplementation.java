package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

/**
 * This class is used to Take the Screenshot and to generate Report
 * 
 * @author Apurva
 */
public class ListenerImplementation implements ITestListener, ISuiteListener {

	public static ExtentReports report;
	public static ExtentTest test;

	/**
	 * This method is used for report configuration
	 */
	public void onStart(ISuite suite) {

		/* Spark Report configuration */
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Result");
		spark.config().setTheme(Theme.DARK);

		/* Add environment info and create test */
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome");
	}

	/**
	 * This method is used to take report back-up
	 */
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	/**
	 * This method is used to create the test
	 */
	public void onTestStart(ITestResult result) {
		System.out.println("======>"+ result.getMethod().getMethodName() + "===START===");
		UtilityClassObject.setTest(test);
		test = report.createTest(result.getMethod().getMethodName());
	}

	/**
	 * This method is used to take screenshot when the test is passed
	 */
	public void onTestSuccess(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot screenshot = (TakesScreenshot) UtilityClassObject.getDriver();;
		String filepath = screenshot.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, testname + "_" + time);
		UtilityClassObject.getTest().log(Status.PASS, "===>" + result.getMethod().getMethodName() + ">===END===");
	}

	/**
	 * This method is used to take screenshot when the test is failed
	 */
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot screenshot = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = screenshot.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, testname + "_" + time);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "===COMPLETED===");
	}
}
