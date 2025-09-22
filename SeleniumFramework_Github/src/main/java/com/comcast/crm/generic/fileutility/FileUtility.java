package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is for performing Properties File related action
 * @author Apurva
 */
public class FileUtility {
	
	/**
	 * This method is used to read common data from Excel 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configAppData/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);

		return data;

	}
}
