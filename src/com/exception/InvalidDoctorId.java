package com.exception;

public class InvalidDoctorId extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidDoctorId(String message) {
		super();
		this.message = message;
		
	}
	public String getMessage()
	{
		return this.message;
	}

}
