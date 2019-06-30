/**
 * Project: employee-application
 * File: ResponseCodes.java
 * Date: Jun 28, 2019
 * Time: 1:52:39 PM
 */

package com.caseytoews.webapp.employee.controller.responsecodes;

/**
 * @author Casey Toews, A00984935
 *
 */
public interface ResponseCodes {

	static final String SUCCESS_CODE = "200";
	static final String SUCCESS_ADD_DSCR = "Employee succesfully added: ";
	static final String SUCCESS_FIND_DSCR = "Employee succesfully found: ";
	static final String SUCCESS_DELETE_DSCR = "Employee succesfully deleted with ID: ";

	static final String ERR_CODE = "500";
	static final String ERR_SYSTEM_DSCR = "Unable to process. Please try again.";
	static final String ERR_ADD_DSCR = "Unable to add employee: ";
	static final String ERR_DOB_DSCR = "Unable to parse the DOB: ";
	static final String ERR_FIND_DSCR = "Unable to find employee: ";
	static final String ERR_ALL_DSCR = "Unable to get employee list.";
	static final String ERR_DELETE_DSCR = "Unable to delete employee wiht ID: ";

	// ID CODES - 510
	static final String INVALID_ID_CODE = "510";
	static final String NO_ID_DSCR = "No ID entered";
	static final String BAD_ID_DSCR = "Invalid ID format.";
	static final String EXIST_ID_DSCR = "This ID already exists.";

	// NAME CODES - 511
	static final String INVALID_NAME_CODE = "511";
	static final String BAD_NAME_DSCR = "Names may only contain letters";
	static final String NO_FNAME_DSCR = "Please provide first name";
	static final String NO_LNAME_DSCR = "Please provide last name";

	// DOB CODES - 512
	static final String INVALID_DOB_CODE = "512";
	static final String BAD_DOB_DSCR = "Invalid DOB format";
	static final String NO_DOB_DSCR = "Please provide a DOB";
	static final String X_DOB_DSCR = "Could not ";
}
