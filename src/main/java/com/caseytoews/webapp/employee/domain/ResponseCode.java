/**
 * Project: employee-application
 * File: ResponseCode.java
 * Date: Jun 25, 2019
 * Time: 5:00:28 PM
 */

package com.caseytoews.webapp.employee.domain;

/**
 * @author Casey Toews
 *
 */
public class ResponseCode {

	private String code;
	private String description;

	public ResponseCode(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResponseCode [code=" + code + ", description=" + description + "]";
	}

}
