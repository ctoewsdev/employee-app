/**
 * Project: employee-application
 * File: AddEmployee.java
 * Date: Jun 28, 2019
 * Time: 10:57:37 AM
 */

package com.caseytoews.webapp.employee.controller.commands;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.caseytoews.webapp.employee.domain.Employee;
import com.caseytoews.webapp.employee.domain.ResponseCodes;

public class DeleteEmployee extends Command {

	public DeleteEmployee() {

	}

	@Override
	public void execute(HttpServletRequest request) {
		ResponseCodes cmdResp = new ResponseCodes();
		Employee emp = new Employee();
		String ID = request.getParameter("idToDelete");

		if (ID.isEmpty() || ID == null) {//
			cmdResp.setCode(INVALID_ID_CODE);
			cmdResp.setDscr(NO_ID_DSCR);
		} else if (!vtor.isIDValid(ID)) {
			cmdResp.setCode(INVALID_ID_CODE);
			cmdResp.setDscr(BAD_ID_DSCR);
		} else {

			try {
				emp.setID(request.getParameter("idToDelete"));
				if (service.deleteEmployee(emp)) {
					cmdResp.setCode(SUCCESS_CODE);
					cmdResp.setDscr(SUCCESS_DELETE_DSCR + emp.getFirstName() + " " + emp.getLastName());
					request.setAttribute("foundEmp", emp);
				} else {
					cmdResp.setCode(ERR_CODE);
					cmdResp.setDscr(ERR_DELETE_DSCR + ID);
				}
			} catch (ClassNotFoundException | SQLException e) {
				cmdResp.setCode(ERR_CODE);
				cmdResp.setDscr(ERR_SYSTEM_DSCR);

			}
		}
		request.setAttribute("findReponse", cmdResp);
	}
}
