package com.udemy.restservices.exceptions;

import java.util.Date;

public class CustomErrorDetails {

	private Date timestamp;
	private String message;
	private String errordetails;

	public CustomErrorDetails(Date timestamp, String message, String errordetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errordetails = errordetails;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getErrordetails() {
		return errordetails;
	}

}
