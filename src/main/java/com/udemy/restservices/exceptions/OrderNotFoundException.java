package com.udemy.restservices.exceptions;

public class OrderNotFoundException extends Exception {
	
	private static final long serialVersionUID = -8918706101130324330L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
