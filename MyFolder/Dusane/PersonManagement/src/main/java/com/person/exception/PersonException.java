package com.person.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class PersonException extends RuntimeException {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	int code;
	String message;

	public PersonException(int code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

}
