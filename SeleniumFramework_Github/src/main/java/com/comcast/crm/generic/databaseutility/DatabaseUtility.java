package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * This class is for performing Database related actions
 * @author Apurva
 */
public class DatabaseUtility {

	Connection conn;

	/**
	 * This method is used to set the Connection with Database
	 * @param url
	 * @param username
	 * @param password
	 * @throws Throwable
	 */
	public void getDBConnection(String url, String username, String password) throws Throwable {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
	}

	/**
	 * This method is used to close the database connection
	 */
	public void closeDBConnection() {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	/**
	 * This method is used for executing Select Query
	 * @param query
	 * @return
	 */
	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {
		}
		return result;
	}
}
