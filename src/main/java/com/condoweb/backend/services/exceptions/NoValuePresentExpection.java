package com.condoweb.backend.services.exceptions;

public class NoValuePresentExpection extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NoValuePresentExpection(String msg) {
		super(msg);
	}
}
