package com.nauka.spring5.rest.crm.exceptions;

public class CustomerException extends RuntimeException {

	public CustomerException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CustomerException(String arg0) {
		super(arg0);
	}

	public CustomerException(Throwable arg0) {
		super(arg0);
	}
}