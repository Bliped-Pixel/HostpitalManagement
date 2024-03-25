package com.exception;

public class InvalidAppointmentId extends Exception{

	private static final long serialVersionUID = -1265952780706891351L;
	
	private String message;

	public InvalidAppointmentId(String message) {
		super();
		this.message = message;
	}
	public String getMessage()
	{
		return this.message;
	}
	
	

}
