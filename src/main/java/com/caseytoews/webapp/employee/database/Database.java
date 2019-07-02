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

	public Database() {
		super();
	}

	public void init(String driver, String url, String user, String password) {
		Database.driver = driver;
		Database.user = user;
		Database.password = password;
		Database.url = url;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ec) {
			ec.printStackTrace();
		} catch (SQLException es) {
			es.printStackTrace();
		}
	}

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
