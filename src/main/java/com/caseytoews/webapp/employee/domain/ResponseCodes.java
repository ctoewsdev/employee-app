/**
 * Project: employee-application
 * File: ResponseCode.java
 * Date: Jun 25, 2019
 * Time: 5:00:28 PM
 */

package com.caseytoews.webapp.employee.domain;

public class ResponseCodes {

	private String code;
	private String dscr;

	public ResponseCodes() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDscr() {
		return dscr;
	}

	public void setDscr(String description) {
		this.dscr = description;
	}

	@Override
	public String toString() {
		return "CommandResponse [code=" + code + ", description=" + dscr + "]";
	}

}
