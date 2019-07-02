/**
 * Project: employee-application
 * File: EmployeeDAO.java
 * Date: Jun 21, 2019
 * Time: 5:22:19 PM
 */

package com.caseytoews.webapp.employee.database;

import java.sql.SQLException;
import java.util.ArrayList;

import com.caseytoews.webapp.employee.domain.Employee;

public interface EmployeeDAO {

	final static String TABLE = "Employees";
	final static String ID_FIELD = "ID";
	final static String FNAME_FIELD = "firstName";
	final static String LNAME_FIELD = "lastName";
	final static String DOB_FIELD = "dob";

	final static String GET_ALL_EMP = String.format("SELECT * from %s", TABLE);

	final static String ADD_EMP = String.format("INSERT INTO %s ([%s] ,[%s],[%s],[%s]) VALUES (?,?,?,?)", TABLE, ID_FIELD, FNAME_FIELD, LNAME_FIELD,
			DOB_FIELD);

	final static String DELETE_EMP = String.format("DELETE FROM %s WHERE %s=?", TABLE, ID_FIELD);

	final static String FIND_EMP_BY_ID = String.format("SELECT * FROM %s WHERE %s=?", TABLE, ID_FIELD);

	ArrayList<Employee> getAllEmployees() throws ClassNotFoundException, SQLException;

	Employee findEmployeeById(String ID) throws ClassNotFoundException, SQLException;

	boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException;

	boolean deleteEmployee(String ID) throws ClassNotFoundException, SQLException;

	void close();
}
