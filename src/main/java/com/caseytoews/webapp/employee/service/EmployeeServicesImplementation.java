/**
 * Project: employee-application
 * File: EmployeeServicesImplementation.java
 * Date: Jun 8, 2019
 * Time: 4:44:22 PM
 */

package com.caseytoews.webapp.employee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.caseytoews.webapp.employee.database.EmployeeDAOImplementation;
import com.caseytoews.webapp.employee.domain.Employee;

/**
 * @author Casey Toews
 *
 */
public class EmployeeServicesImplementation implements EmployeeServices {
	private EmployeeDAOImplementation empDAO;
	private String resultCode;

	public EmployeeServicesImplementation() {
		empDAO = new EmployeeDAOImplementation();
	}

	@Override
	public ArrayList<Employee> getEmployeesList() throws ClassNotFoundException, SQLException {

		return empDAO.getAllEmployees();
	}

	@Override
	public Employee findEmployeeById(String ID) throws ClassNotFoundException, SQLException {

		return empDAO.findEmployeeById(ID);

	}

	@Override
	public boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		return empDAO.addEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Employee emp) throws ClassNotFoundException, SQLException {

		return empDAO.deleteEmployee(emp);
	}

}
