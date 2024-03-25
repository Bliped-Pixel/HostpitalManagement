package com.exception;

public class PatientNumberNotFound extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public PatientNumberNotFound(String message) {
		super();
		this.message = message;
	}
	public String getMessage()
	{
		return this.message;
	}

}
