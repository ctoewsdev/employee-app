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
		super();
	}

	@Override
	public void execute(HttpServletRequest request) {
		ResponseCodes cmdResp = new ResponseCodes();
		String ID = request.getParameter("idToDelete");

		if (ID.isEmpty() || ID == null) {//
			cmdResp.setCode(INVALID_ID_CODE);
			cmdResp.setDscr(NO_ID_DSCR);
		} else if (!vtor.isIDValid(ID)) {
			cmdResp.setCode(INVALID_ID_CODE);
			cmdResp.setDscr(BAD_ID_DSCR);
		} else {

			try {
				Employee deleteEmp = new Employee();
				deleteEmp = service.findEmployeeById(ID);
				if (service.deleteEmployee(ID)) {
					cmdResp.setCode(SUCCESS_CODE);
					cmdResp.setDscr(SUCCESS_DELETE_DSCR);
					request.setAttribute("deleteEmp", deleteEmp);
				} else {
					cmdResp.setCode(ERR_CODE);
					cmdResp.setDscr(ERR_DELETE_DSCR + "<br>ID: " + ID);
				}
			} catch (ClassNotFoundException | SQLException e) {
				cmdResp.setCode(ERR_CODE);
				cmdResp.setDscr(ERR_SYSTEM_DSCR);
			}
		}
		request.setAttribute("deleteResponse", cmdResp);
	}
}
