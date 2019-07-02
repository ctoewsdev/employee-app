/**
 * Project: employee-application
 * File: EmployeeServlet.java
 * Date: Jun 28, 2019
 * Time: 10:57:37 AM
 */
package com.caseytoews.webapp.employee.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caseytoews.webapp.employee.controller.commands.AddEmployee;
import com.caseytoews.webapp.employee.controller.commands.DeleteEmployee;
import com.caseytoews.webapp.employee.controller.commands.FindEmployeeByID;
import com.caseytoews.webapp.employee.controller.commands.GetAllEmployees;
import com.caseytoews.webapp.employee.database.Database;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		new Database().init(config.getInitParameter("driver"), config.getInitParameter("url"), config.getInitParameter("user"),
				config.getInitParameter("password"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// CREATE DISPATCH OBJECT
		String address = "/JSP/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);

		// ADD EMPLOYEE
		if ("add".equals(request.getParameter("action"))) {
			AddEmployee command = new AddEmployee();
			command.execute(request);
		}

		// FIND EMPLOYEE BY ID
		else if ("find".equals(request.getParameter("action"))) {
			FindEmployeeByID command = new FindEmployeeByID();
			command.execute(request);
		}

		// DELETE EMPLOYEE BY ID
		else if ("delete".equals(request.getParameter("action"))) {
			DeleteEmployee command = new DeleteEmployee();
			command.execute(request);
		}

		// GET EMPLOYEES LIST
		GetAllEmployees command = new GetAllEmployees();
		command.execute(request);

		// DISPATCH RREQUEST TO INDEX.JSP
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
