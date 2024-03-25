package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.exception.InvalidAppointmentId;
import com.exception.InvalidDoctorId;
import com.exception.PatientNumberNotFound;
import com.model.Appointment;

public class HospitalService {
	
	public Appointment getAppointmentById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.getAppointmentById(id);
		
	}
	public List<Appointment> getAppoinmentForPatient(int id) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.getAppoinmentForPatient(id);
	}
	public List<Appointment> getAppoinmentForDoctor(int id) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.getAppoinmentForDoctor(id);
		
	}
	public boolean scheduleAppoinment(Appointment appointment) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.scheduleAppoinment(appointment);
		
		
	}
	public boolean updateAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.updateAppointment(appointment);
		
	}
	public boolean cancelAppointment(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.cancelAppointment(id);
	}
	public boolean appointmentIdExsist(int id) throws ClassNotFoundException, SQLException, InvalidAppointmentId {
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.appointmentIdExsist(id);
	}
	public boolean patientIdExsist(int id) throws ClassNotFoundException, SQLException, PatientNumberNotFound {
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.patientIdExsist(id);

	}
	public boolean doctorIdExsist(int id) throws ClassNotFoundException, SQLException, InvalidDoctorId {
		// TODO Auto-generated method stub
		HospitalDao dao = new HospitalDaoImpl();
		return dao.doctorIdExsist(id);
	}

}
