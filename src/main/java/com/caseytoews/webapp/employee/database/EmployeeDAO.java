/**
 * Project: employee-application
 * File: EmployeeDAO.java
 * Date: Jun 21, 2019
 * Time: 5:22:19 PM
 */

package com.caseytoews.webapp.employee.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.caseytoews.webapp.employee.domain.Employee;

/**
 * @author Casey Toews
 *
 */
public interface EmployeeDAO {

	static final String BUNDLE_NAME = "db";
	static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	final static String DRIVER = Properties.getString(BUNDLE, "driver");
	final static String HOST = Properties.getString(BUNDLE, "host");
	final static String USER = Properties.getString(BUNDLE, "user");
	final static String PASSWORD = Properties.getString(BUNDLE, "password");
	final static String DB = Properties.getString(BUNDLE, "database");
	final static String TABLE = Properties.getString(BUNDLE, "table");
	final static String ID_FIELD = Properties.getString(BUNDLE, "id");
	final static String FNAME_FIELD = Properties.getString(BUNDLE, "firstname");
	final static String LNAME_FIELD = Properties.getString(BUNDLE, "lastname");
	final static String DOB_FIELD = Properties.getString(BUNDLE, "dob");

	final static String GET_ALL_EMP = String.format("SELECT * from %s", TABLE);

	final static String ADD_EMP = String.format("INSERT INTO %s ([%s] ,[%s],[%s],[%s]) VALUES (?,?,?,?)", TABLE, ID_FIELD, FNAME_FIELD, DOB_FIELD);

	final static String DELETE_EMP = String.format("DELETE FROM %s WHERE %s=?", TABLE, ID_FIELD);

	final static String FIND_EMP_BY_ID = String.format("SELECT * FROM %s WHERE %s=?", TABLE, ID_FIELD);

	ArrayList<Employee> getAllEmployees() throws ClassNotFoundException, SQLException;;

	Employee getById(String id) throws ClassNotFoundException, SQLException;;

	boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException;;

	boolean deleteEmployee(Employee employee) throws ClassNotFoundException, SQLException;;

}
