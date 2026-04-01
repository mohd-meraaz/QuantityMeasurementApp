package com.app.microservices.quantity_service.exception;

public class InvalidUnitException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUnitException(String msg) {
		super(msg);
	}
}
