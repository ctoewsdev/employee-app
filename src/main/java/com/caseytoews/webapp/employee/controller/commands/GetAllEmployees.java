/**
 * Project: employee-application
 * File: AddEmployee.java
 * Date: Jun 28, 2019
 * Time: 10:57:37 AM
 */

package com.caseytoews.webapp.employee.controller.commands;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.caseytoews.webapp.employee.domain.Employee;
import com.caseytoews.webapp.employee.domain.ResponseCodes;

public class GetAllEmployees extends Command {

	public GetAllEmployees() {

	}

	@Override
	public void execute(HttpServletRequest request) {
		ResponseCodes cmdResp = new ResponseCodes();

		ArrayList<Employee> employeesList;
		try {
			employeesList = service.getEmployeesList();
			request.setAttribute("empList", employeesList);
		} catch (ClassNotFoundException | SQLException e) {
			cmdResp.setCode(ERR_CODE);
			cmdResp.setDscr(ERR_ALL_DSCR);
		}
	}
}