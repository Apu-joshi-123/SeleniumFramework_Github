package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class is used to fetch the data from JSON File
 * @author Apurva
 */
public class JSONUtility {

	/**
	 * This method is used to read the common data from JSON File
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String getDataFromJSONFile(String key) throws IOException, ParseException {
		FileReader fr = new FileReader("./configAppData/commondata.JSON");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject map = (JSONObject) obj;
		String data = (String) map.get(key);

		return data;

	}
}
