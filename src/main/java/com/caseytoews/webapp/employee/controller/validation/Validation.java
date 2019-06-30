/**
 * Project: employee-application
 * File: Validation.java
 * Date: Jun 29, 2019
 * Time: 10:41:10 AM
 */

package com.caseytoews.webapp.employee.controller.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Casey Toews
 *         Class validation is inherited by Command class
 */
public class Validation {

	private static final String idRegex = "^E0[0-9]{7}$";
	private static final String nameRegex = "^[A-z]+$";
	private static final String dateRegex = "^[0-9]{4}[/-][0-9]{2}[/-][0-9]{2}$";
	private static final String dobRegex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

	public Validation() {

	}

	public boolean isIDValid(String id) {
		Pattern pattern = Pattern.compile(idRegex);
		Matcher matcher = pattern.matcher(id);
		return matcher.matches();
	}

	public boolean isNameValid(String name) {
		Pattern pattern = Pattern.compile(nameRegex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public boolean isDateValid(String date) {
		Pattern pattern = Pattern.compile(dateRegex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

	public Date getDOBDateObject(String date) throws ParseException {
		Date empDOB;
		Pattern pattern = Pattern.compile(dobRegex);
		Matcher matcher = pattern.matcher(date);
		if (matcher.matches()) {
			empDOB = new SimpleDateFormat("yyyy-dd-MM").parse(date);

		} else {
			empDOB = new SimpleDateFormat("yyyy/MM/dd").parse(date);
		}
		return empDOB;
	}

}
