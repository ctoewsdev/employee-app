/**
 * Project: employee-application
 * File: EmployeeDAOImplementation.java
 * Date: Jun 8, 2019
 * Time: 2:33:33 PM
 */

package com.caseytoews.webapp.employee.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.caseytoews.webapp.employee.domain.Employee;

/**
 * @author Casey Toews
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	public EmployeeDAOImpl() {
		super();
	}

	@Override
	public ArrayList<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
		ArrayList<Employee> employees = new ArrayList<>();
		connection = Database.getConnection();
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		resultSet = statement.executeQuery(GET_ALL_EMP);

		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setID(resultSet.getString(ID_FIELD));
			employee.setFirstName(resultSet.getString(FNAME_FIELD));
			employee.setLastName(resultSet.getString(LNAME_FIELD));
			employee.setDob(resultSet.getDate(DOB_FIELD));
			// java.sql.Date dbSqlDate = resultSet.getDate(DOB_FIELD);
			// java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
			// employee.setDOB(dbSqlDateConverted);
			employees.add(employee);
		}

		return employees;
	}

	@Override
	public Employee findEmployeeById(String ID) throws ClassNotFoundException, SQLException {
		connection = Database.getConnection();
		preparedStatement = connection.prepareStatement(FIND_EMP_BY_ID);
		preparedStatement.setString(1, ID);
		resultSet = preparedStatement.executeQuery();
		Employee employee = new Employee();
		while (resultSet.next()) {
			employee.setID(resultSet.getString(ID_FIELD));
			employee.setFirstName(resultSet.getString(FNAME_FIELD));
			employee.setLastName(resultSet.getString(LNAME_FIELD));
			employee.setDob(resultSet.getDate(DOB_FIELD));
			return employee;
		}

		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		// have to convert the java.util.Date to sql Date
		java.sql.Date sqlDOB = new java.sql.Date(employee.getDob().getTime());
		boolean isAdded = false;
		connection = Database.getConnection();
		preparedStatement = connection.prepareStatement(ADD_EMP);

		preparedStatement.setString(1, employee.getID());
		preparedStatement.setString(2, employee.getFirstName());
		preparedStatement.setString(3, employee.getLastName());
		preparedStatement.setDate(4, sqlDOB);

		int x = preparedStatement.executeUpdate();

		if (x == 1) {
			isAdded = true;
		}

		return isAdded;
	}

	@Override
	public boolean deleteEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		boolean isDeleted = false;

		connection = Database.getConnection();
		preparedStatement = connection.prepareStatement(DELETE_EMP);
		preparedStatement.setString(1, employee.getID());

		int x = preparedStatement.executeUpdate();

		if (x == 1) {
			isDeleted = true;
		}

		return isDeleted;
	}

	/**
	 * method shutdown() closes the DB connection
	 * 
	 * 
	 */
	public void shutdown() {
		if (connection != null) {
			try {

				connection.close();
				connection = null;
			} catch (SQLException e) {

			}
		}
	}

}