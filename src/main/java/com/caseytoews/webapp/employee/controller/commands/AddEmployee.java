/**
 * Project: employee-application
 * File: AddEmployee.java
 * Date: Jun 28, 2019
 * Time: 10:57:37 AM
 */

package com.caseytoews.webapp.employee.controller.commands;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.caseytoews.webapp.employee.domain.Employee;
import com.caseytoews.webapp.employee.domain.ResponseCodes;

public class AddEmployee extends Command {

	public AddEmployee() {
		super();
	}

	@Override
	public void execute(HttpServletRequest request) {
		ResponseCodes cmdResp = new ResponseCodes();
		Employee emp = new Employee();
		emp.setID(request.getParameter("addID"));
		emp.setFirstName(request.getParameter("addFirstName"));
		emp.setLastName(request.getParameter("addLastName"));

		if (emp.getID().isEmpty() || emp.getID() == null) {//
			cmdResp.setCode(INVALID_ID_CODE);
			cmdResp.setDscr(NO_ID_DSCR);
		} else if (!vtor.isIDValid(emp.getID())) {
			cmdResp.setCode(INVALID_ID_CODE);
			cmdResp.setDscr(BAD_ID_DSCR);
		} else if (emp.getFirstName().isEmpty() || emp.getFirstName() == null) {//
			cmdResp.setCode(INVALID_NAME_CODE);
			cmdResp.setDscr(NO_FNAME_DSCR);
		} else if (emp.getLastName().isEmpty() || emp.getLastName() == null) {//
			cmdResp.setCode(INVALID_NAME_CODE);
			cmdResp.setDscr(NO_LNAME_DSCR);
		} else if (!vtor.isNameValid(emp.getFirstName()) || !vtor.isNameValid(emp.getLastName())) {//
			cmdResp.setCode(INVALID_NAME_CODE);
			cmdResp.setDscr(BAD_NAME_DSCR);
		} else if (request.getParameter("addDOB").isEmpty() || request.getParameter("addDOB") == null) {//
			cmdResp.setCode(INVALID_DOB_CODE);
			cmdResp.setDscr(NO_DOB_DSCR);
		} else if (!vtor.isDateValid(request.getParameter("addDOB"))) {
			cmdResp.setCode(INVALID_DOB_CODE);
			cmdResp.setDscr(BAD_DOB_DSCR);
		} else {

			try {
				Employee existingEmp = service.findEmployeeById(emp.getID());
				if (existingEmp != null) {
					cmdResp.setCode(INVALID_ID_CODE);
					cmdResp.setDscr(EXIST_ID_DSCR + "<br>ID: " + emp.getID());
					request.setAttribute("addResponse", cmdResp);
					return;
				}
			} catch (ClassNotFoundException | SQLException e) {
				cmdResp.setCode(ERR_CODE);
				cmdResp.setDscr(ERR_SYSTEM_DSCR);
				request.setAttribute("addResponse", cmdResp);
				return;
			}

			try {
				emp.setDob(vtor.getDOBDateObject(request.getParameter("addDOB")));
			} catch (ParseException e) {
				cmdResp.setCode(ERR_CODE);
				cmdResp.setDscr(ERR_DOB_DSCR);
				request.setAttribute("addResponse", cmdResp);
				return;
			}

			try {

				if (service.addEmployee(emp)) {
					cmdResp.setCode(SUCCESS_CODE);
					cmdResp.setDscr(SUCCESS_ADD_DSCR);
					request.setAttribute("addEmp", emp);
				} else {
					cmdResp.setCode(ERR_CODE);
					cmdResp.setDscr(ERR_ADD_DSCR);
					request.setAttribute("addEmp", emp);
				}

			} catch (ClassNotFoundException | SQLException e) {
				cmdResp.setCode(ERR_CODE);
				cmdResp.setDscr(ERR_SYSTEM_DSCR);
				request.setAttribute("addResponse", cmdResp);
			}
		}

		request.setAttribute("addResponse", cmdResp);
	}
}
