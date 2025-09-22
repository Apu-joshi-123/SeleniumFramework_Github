package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class is used to perform java related actions
 * @author Apurva
 */
public class JavaUtility {

	/**
	 * This method is used when the application does not support unique values
	 * @return
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	/**
	 * This method is used to fetch the current system date
	 * @return
	 */
	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}

	/**
	 * This method is used to fetch the date after or before the given days
	 * @param days
	 * @return
	 */
	public String getRequiredDateYYYYMMDD(int days) {
		//Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;

	}
}
