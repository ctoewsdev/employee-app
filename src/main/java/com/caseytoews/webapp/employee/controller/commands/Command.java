/**
 * Project: employee-application
 * File: Command.java
 * Date: Jun 28, 2019
 * Time: 12:15:38 PM
 */

package com.caseytoews.webapp.employee.controller.commands;

import javax.servlet.http.HttpServletRequest;

import com.caseytoews.webapp.employee.controller.responsecodes.ResponseCodes;
import com.caseytoews.webapp.employee.controller.validation.Validation;
import com.caseytoews.webapp.employee.service.EmployeeServices;
import com.caseytoews.webapp.employee.service.EmployeeServicesImpl;

/**
 * @author Casey Toews
 *         Class Command is inherited by controller action classes
 */
public abstract class Command implements ResponseCodes {

	protected EmployeeServices service;
	protected Validation vtor;

	public Command() {

		service = new EmployeeServicesImpl();
		vtor = new Validation();
	}

	public abstract void execute(HttpServletRequest request);

}
