package com.udemy.restservices.exceptions;

public class UserNameNotFoundException extends Exception {

	private static final long serialVersionUID = -5078263488050249111L;

	public UserNameNotFoundException(String message) {
		super(message);
	}

}
