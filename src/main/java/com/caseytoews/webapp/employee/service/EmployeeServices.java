/**
 * Project: employee-application
 * File: EmployeeServices.java
 * Date: Jun 8, 2019
 * Time: 4:43:05 PM
 */

package com.caseytoews.webapp.employee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.caseytoews.webapp.employee.domain.Employee;

/**
 * @author Casey Toews
 *
 */
public interface EmployeeServices {

	ArrayList<Employee> getEmployeesList() throws ClassNotFoundException, SQLException;

	Employee findEmployeeById(String ID) throws ClassNotFoundException, SQLException;

	boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException;

	boolean deleteEmployee(String ID) throws ClassNotFoundException, SQLException;

}
