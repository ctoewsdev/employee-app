package com.caseytoews.webapp.employee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.caseytoews.webapp.employee.database.Database;
import com.caseytoews.webapp.employee.domain.Employee;
import com.caseytoews.webapp.employee.service.EmployeeServicesImplementation;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger LOG = Logger.getLogger(EmployeeServlet.class);

	private EmployeeServicesImplementation empServices;
	private boolean isFindForm = false;
	private boolean isDeleteForm = false;
	private boolean isAddForm = false;
	// private String resultCode;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		new Database().init(config.getInitParameter("driver"), config.getInitParameter("url"), config.getInitParameter("user"),
				config.getInitParameter("password"));
		LOG.info("Database is connected!");

		// INSTANTIATE SERVICE LAYER
		// empServices = new EmployeeServicesImplementation();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// IDENTIFY WHICH FORM HAS BEEN SUBMITTED
		isAddForm = request.getParameter("add") != null ? true : false;
		isFindForm = request.getParameter("find") != null ? true : false;
		isDeleteForm = request.getParameter("delete") != null ? true : false;

		// CREATE DISPATCH OBJECT
		String address = "/JSP/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);

		String action = request.getParameter("action");
		if (action != null && !action.isEmpty()) {
			if (action.equals("student")) {
				// to do rest of code..
			} else if (action.equals("teacher")) {
				// to do rest of code..
			}

		}

		// ADD EMPLOYEE
		if (isAddForm) {
			String employee[] = new String[4];
			employee[0] = request.getParameter("addID");
			employee[1] = request.getParameter("addFirstName");
			employee[2] = request.getParameter("addLastName");
			employee[3] = request.getParameter("addDOB");
			resultCode = empServices.addEmployee(employee);
			request.setAttribute("resultCodeAdd", resultCode);
		}

		// FIND EMPLOYEE BY ID
		if (isFindForm) {
			String idToFind = request.getParameter("idToFind");
			resultCode = empServices.getById(idToFind);
			request.setAttribute("resultCodeFind", resultCode);
		}

		// DELETE EMPLOYEE BY ID
		if (isDeleteForm) {
			String idToDelete = request.getParameter("idToDelete");
			resultCode = empServices.deleteEmployee(idToDelete);
			request.setAttribute("resultCodeDelete", resultCode);
		}

		// GET EMPLOYEES LIST
		ArrayList<Employee> employeesList = empServices.getEmployeesList();
		request.setAttribute("empList", employeesList);

		// DISPATCH RREQUEST TO INDEX.JSP
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
