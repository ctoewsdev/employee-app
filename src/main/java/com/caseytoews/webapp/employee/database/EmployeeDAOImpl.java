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
			employees.add(employee);
		}

		close();

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

		close();

		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		java.sql.Date sqlDOB = new java.sql.Date(employee.getDob().getTime());
		boolean isAdded = false;
		connection = Database.getConnection();
		preparedStatement = connection.prepareStatement(ADD_EMP);

		preparedStatement.setString(1, employee.getID());
		preparedStatement.setString(2, employee.getFirstName());
		preparedStatement.setString(3, employee.getLastName());
		preparedStatement.setDate(4, sqlDOB);

		System.out.println(preparedStatement);

		int x = preparedStatement.executeUpdate();

		if (x == 1) {
			isAdded = true;
		}

		close();

		return isAdded;
	}

	@Override
	public boolean deleteEmployee(String ID) throws ClassNotFoundException, SQLException {

		boolean isDeleted = false;

		connection = Database.getConnection();
		preparedStatement = connection.prepareStatement(DELETE_EMP);
		preparedStatement.setString(1, ID);

		int x = preparedStatement.executeUpdate();

		if (x == 1) {
			isDeleted = true;
		}

		close();

		return isDeleted;
	}

	@Override
	public void close() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
