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

public class FindEmployeeByID extends Command {

	public FindEmployeeByID() {

	}

	@Override
	public void execute(HttpServletRequest request) {
		ResponseCodes cmdResp = new ResponseCodes();
		String ID = (request.getParameter("idToFind"));
		System.out.println("id to find :" + ID);

		if (ID.isEmpty() || ID == null) {//
			System.out.println("empty id");
			cmdResp.setCode(INVALID_ID_CODE);
			cmdResp.setDscr(NO_ID_DSCR);
		} else if (!vtor.isIDValid(ID)) {
			System.out.println("invalid id");
			cmdResp.setCode(INVALID_ID_CODE);
			cmdResp.setDscr(BAD_ID_DSCR);
		} else {

			try {
				Employee emp = service.findEmployeeById(ID);
				if (emp != null) {
					System.out.println("found id");
					cmdResp.setCode(SUCCESS_CODE);
					cmdResp.setDscr(SUCCESS_FIND_DSCR);
					request.setAttribute("foundEmp", emp);
				} else {
					System.out.println("not found id");
					cmdResp.setCode(ERR_CODE);
					cmdResp.setDscr(ERR_FIND_DSCR + ID);
				}
			} catch (ClassNotFoundException | SQLException e) {
				cmdResp.setCode(ERR_CODE);
				cmdResp.setDscr(ERR_SYSTEM_DSCR);

			}
		}
		request.setAttribute("findResponse", cmdResp);
		System.out.println(cmdResp.getCode() + " " + cmdResp.getDscr());
	}
}
