/**
 * Project: employee-application
 * File: EmployeeServicesImplementation.java
 * Date: Jun 8, 2019
 * Time: 4:44:22 PM
 */

package com.caseytoews.webapp.employee.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	/*
	 * (non-Javadoc)
	 * @see ca.bcit.comp3656.assignment1.services.EmployeeServices#getById(java.lang.String)
	 */
	@Override
	public String getById(String id) {

		if (id == null || id.isEmpty()) {//
			resultCode = "Result Code: 900 Description: No ID entered";
		} else if (!isIDValid(id)) {
			resultCode = "Result Code: 901 Description: Invalid ID entered";
		} else {
			Employee foundEmp = empDAO.getById(id);
			if (foundEmp != null) {
				resultCode = "Found " + foundEmp.getFirstName() + " " + foundEmp.getLastName() + "<br>Result Code: 000 Description: Success";
			} else {
				resultCode = "Result Code: 801 Description: No match found";
			}
		}
		return resultCode;
	}

	/*
	 * (non-Javadoc)
	 * @see ca.bcit.comp3656.assignment1.services.EmployeeServices#addEmployee(ca.bcit.comp3656.assignment1.domain.Employee)
	 */
	@Override
	public String addEmployee(String employee[]) {
		String id = employee[0];
		String firstName = employee[1];
		String lastName = employee[2];
		String dob = employee[3];

		if (id.isEmpty() || id == null) {//
			resultCode = "Result Code: 900 Description: No ID entered";
		} else if (!isIDValid(id)) {
			resultCode = "Result Code: 901 Description: Invalid ID entered";
		} else if (firstName.isEmpty() || firstName == null) {//
			resultCode = "Result Code: 903 Description: Must provide first name";
		} else if (lastName.isEmpty() || lastName == null) {//
			resultCode = "Result Code: 904 Description: Must provide last name";
		} else if (!isNameValid(firstName) || !isNameValid(lastName)) {//
			resultCode = "Result Code: 905 Description: Names may only contain letters";
		} else if (dob.isEmpty() || dob == null) {//
			resultCode = "Result Code: 906 Description: Must provide DOB";
		} else if (!isDateValid(dob)) {
			resultCode = "Result Code: 907 Description: Invalid DOB format";
		}

		else {
			boolean isEmpAlreadyExist = isEmployeeExist(id);

			if (!isEmpAlreadyExist) {

				Employee addEmployee = new Employee();
				addEmployee.setID(id);
				addEmployee.setFirstName(firstName);
				addEmployee.setLastName(lastName);

				try {
					addEmployee.setDOB(getDOBDateObject(dob));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (empDAO.addEmployee(addEmployee)) {
					resultCode = "Result Code: 200 Description: Success";
				} else {
					resultCode = "Result Code: 906 Description: Unable to add employee";
				}

			} else {
				resultCode = "Result Code: 905 Description: ID already exists for another employee";
			}
		}

		return resultCode;
	}

	/*
	 * (non-Javadoc)
	 * @see ca.bcit.comp3656.assignment1.services.EmployeeServices#deleteEmployee(ca.bcit.comp3656.assignment1.domain.Employee)
	 */
	@Override
	public String deleteEmployee(String id) {

		if (id == null || id.isEmpty()) {//
			resultCode = "Result Code: 900 Description: No ID entered";
		}

		else if (!isIDValid(id)) {
			resultCode = "Result Code: 901 Description: Invalid ID entered";
		}

		else {
			boolean isDeleted = empDAO.deleteEmployee(id);
			if (isDeleted) {
				resultCode = "Result Code: 001 Description: Deleted Successfully";
			} else {
				resultCode = "Result Code: 902 Description: Delete Unsuccesful";
			}
		}
		return resultCode;
	}

	/*
	 * (non-Javadoc)
	 * @see ca.bcit.comp3656.assignment1.services.EmployeeServices#isEmployeeExist(java.lang.String)
	 */
	@Override
	public boolean isEmployeeExist(String id) {
		Employee emp = empDAO.getById(id);
		if (emp == null) {
			return false;
		} else {
			return true;
		}
	}

	// VALIDATION METHODS
	private boolean isIDValid(String id) {
		String regex = "^A0[0-9]{7}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}

	private boolean isNameValid(String name) {
		String regex = "^[A-z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	private boolean isDateValid(String date) {
		String regex = "^[0-9]{4}[/-][0-9]{2}[/-][0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

	private Date getDOBDateObject(String date) throws ParseException {
		Date empDOB;
		String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		if (matcher.matches()) {
			empDOB = new SimpleDateFormat("yyyy-dd-MM").parse(date);

		} else {
			empDOB = new SimpleDateFormat("yyyy/MM/dd").parse(date);
		}
		return empDOB;
	}

}
