package com.udemy.restservices.exceptions;

public class UserExistsException extends Exception {

	private static final long serialVersionUID = 8450146116929072342L;

	public UserExistsException(String message) {
		super(message);
	}

}
