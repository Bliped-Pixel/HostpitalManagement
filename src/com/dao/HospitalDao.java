package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.InvalidAppointmentId;
import com.exception.InvalidDoctorId;
import com.exception.PatientNumberNotFound;
import com.model.Appointment;


public interface HospitalDao {

	
	Appointment getAppointmentById(int id) throws ClassNotFoundException, SQLException;
	List<Appointment> getAppoinmentForPatient(int id) throws ClassNotFoundException, SQLException;
	List<Appointment> getAppoinmentForDoctor(int id) throws ClassNotFoundException, SQLException;
	boolean scheduleAppoinment(Appointment a) throws ClassNotFoundException, SQLException;
	boolean updateAppointment(Appointment a) throws ClassNotFoundException, SQLException;
	boolean cancelAppointment(int id) throws ClassNotFoundException, SQLException;
	boolean appointmentIdExsist(int id) throws ClassNotFoundException, SQLException, InvalidAppointmentId;
	boolean patientIdExsist(int id) throws ClassNotFoundException, SQLException, PatientNumberNotFound;
	boolean doctorIdExsist(int id) throws ClassNotFoundException, SQLException, InvalidDoctorId;
	
}
