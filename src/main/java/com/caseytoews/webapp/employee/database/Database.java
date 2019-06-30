package com.caseytoews.webapp.employee.database;

/**
 * Project: Employee-Application
 * File: Database.java
 * Date: Jun 24, 2019
 * Time: 3:11:42 PM
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static Connection connection;
	private static String driver;
	private static String user;
	private static String password;
	private static String url;
	// private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// private static final String DB_URL = "jdbc:sqlserver://Beangrinder.bcit.ca";
	// private static final String DB_USER = "javastudent";
	// private static final String DB_PASSWORD = "compjava";
	// private static final String DB_TABLE_NAME = "a00984935_Employees";
	// private static final String DB_ID_FIELD = "ID";

	public Database() {

	}

	public void init(String driver, String url, String user, String password) {
		Database.driver = driver;
		Database.user = user;
		Database.password = password;
		Database.url = url;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Database error ********************************************************");
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * method getConnection() for retrieving a DB connection
	 * 
	 * @returns a Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	protected static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection != null && !connection.isClosed()) {
			return connection;
		} else {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			return connection;
		}
	}
}
