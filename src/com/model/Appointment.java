package com.model;

import java.util.Date;

public class Appointment {
	
	private int appointmentId;
	private int patientId;
	private int doctorId;
	private Date appoinmentDate;
	private String description;
	
	public Appointment(int patientId, int doctorId, Date appoinmentDate, String description) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appoinmentDate = appoinmentDate;
		this.description = description;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public Date getAppoinmentDate() {
		return appoinmentDate;
	}
	public void setAppoinmentDate(Date appoinmentDate) {
		this.appoinmentDate = appoinmentDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", appoinmentDate=" + appoinmentDate + ", description=" + description + "]";
	}
	
	

}
