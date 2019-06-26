package com.caseytoews.webapp.employee.domain;

/**
 * Project: Employee-Application
 * File: Employee.java
 * Date: Jun 4, 2019
 * Time: 5:22:19 PM
 */

import java.util.Date;

/**
 * @author Casey Toews
 *
 */
public class Employee {

	private String ID;
	private String firstName;
	private String lastName;
	private Date dob;

	public Employee() {

	}

	/**
	 * @return the empID as a Employee
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param empID
	 *            is the empID field to set
	 */
	public void setID(String ID) {
		this.ID = ID;
	}

	/**
	 * @return the firstName as a Employee
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            is the firstName field to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName as a Employee
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            is the lastName field to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the empDOB as a Employee
	 */
	public Date getDOB() {
		return dob;
	}

	/**
	 * @param empDOB
	 *            is the empDOB field to set
	 */
	public void setDOB(Date DOB) {
		this.dob = DOB;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + "]";
	}

}
