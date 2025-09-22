package com.comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is used to re-run the test script whenever it gets failed
 * @author Apurva
 */
public class RetryListenerImplementation implements IRetryAnalyzer {
	int count = 0;
	int limitCount = 0;

	/**
	 * This method is used to re-run the test script n number of times whenever it gets failed
	 */
	public boolean retry(ITestResult result) {
		if (count < limitCount) {
			count++;
			return true;
		}
		return false;
	}
	
	
}
