package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

/**
 * This class is used for creating the global object of WebDriver and Extent Test
 * @author Apurva 
 */
public class UtilityClassObject {

	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to get the ExtentTest reference
	 * @return
	 */
	public static ExtentTest getTest() {
		return test.get();
	}
	
	/**
	 * This method is used to get the WebDriver reference
	 * @return
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	/**
	 * This method is used to set the ExtentTest reference
	 * @param actTest
	 */
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}
	
	/**
	 * This method is used to set the WebDriver reference
	 * @param udriver
	 */
	public static void setDriver(WebDriver udriver) {
		driver.set(udriver);
	}
	
	
}
