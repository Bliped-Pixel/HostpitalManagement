package com.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utility.DbConnection;
import com.model.Appointment;
import com.exception.*;


public class HospitalDaoImpl implements HospitalDao {

	@Override
	public Appointment getAppointmentById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = DbConnection.getDBConn();
		
		String sql = "select * from appointment where appointment_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet result = pstmt.executeQuery();
		Appointment appointment = new Appointment();
		if(result.next()) {
			
			int patientId = result.getInt("patient_id");
			int doctorId = result.getInt("doctor_id");
			java.sql.Date date = result.getDate("appointment_date");
			String descriptioin = result.getString("description");
			
			appointment.setAppointmentId(id);
			appointment.setPatientId(patientId);
			appointment.setDoctorId(doctorId);
			appointment.setAppoinmentDate(date);
			appointment.setDescription(descriptioin);
			
		}
		DbConnection.dbClose();
		return appointment;
	}

	@Override
	public List<Appointment> getAppoinmentForPatient(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDBConn();
		
		String sql = "select * from appointment where patient_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet result = pstmt.executeQuery();
		Appointment appointment = new Appointment();
		List <Appointment> list = new ArrayList<>();
		while(result.next()) {
			
			int appointmentId = result.getInt("appointment_id");
			int doctorId = result.getInt("doctor_id");
			java.sql.Date date = result.getDate("appointment_date");
			String descriptioin = result.getString("description");
			
			appointment.setAppointmentId(appointmentId);
			appointment.setPatientId(id);
			appointment.setDoctorId(doctorId);
			appointment.setAppoinmentDate(date);
			appointment.setDescription(descriptioin);
			list.add(appointment);
		}
		DbConnection.dbClose();
		return list;
	}

	@Override
	public List<Appointment> getAppoinmentForDoctor(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDBConn();
		
		String sql = "select * from appointment where doctor_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet result = pstmt.executeQuery();
		Appointment appointment = new Appointment();
		List <Appointment> list = new ArrayList<>();
		while(result.next()) {
			
			int appointmentId = result.getInt("appointment_id");
			int patientId = result.getInt("patient_id");
			java.sql.Date date = result.getDate("appointment_date");
			String descriptioin = result.getString("description");
			
			appointment.setAppointmentId(appointmentId);
			appointment.setPatientId(patientId);
			appointment.setDoctorId(id);
			appointment.setAppoinmentDate(date);
			appointment.setDescription(descriptioin);
			list.add(appointment);
		}
		DbConnection.dbClose();
		
		return list;
	}

	@Override
	public boolean scheduleAppoinment(Appointment a) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDBConn();
		
		String sql = "Insert into appointment(patient_id,doctor_id,appointment_date,description) values(?,?,?,?)";
		java.sql.Date date = new java.sql.Date(a.getAppoinmentDate().getTime());
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, a.getPatientId());
		pstmt.setInt(2, a.getDoctorId());
		pstmt.setDate(3, date);
		pstmt.setString(4, a.getDescription());
		int result = pstmt.executeUpdate();
		if(result == 1)return true;
		return false;
	}

	@Override
	public boolean updateAppointment(Appointment a) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDBConn();
		
		String sql = "update appointment set patient_id = ?, doctor_id = ?, appointment_date = ?, description = ? where appointment_id = ?";
		java.sql.Date date = new java.sql.Date(a.getAppoinmentDate().getTime());
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, a.getPatientId());
		pstmt.setInt(2, a.getDoctorId());
		pstmt.setDate(3, date);
		pstmt.setString(4, a.getDescription());
		pstmt.setInt(5, a.getAppointmentId());
		boolean result = pstmt.execute();
		return result;
	}

	@Override
	public boolean cancelAppointment(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDBConn();
		
		String sql = "Delete from appointment where appointment_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		boolean result = pstmt.execute();
;		return result;
	}

	@Override
	public boolean appointmentIdExsist(int id) throws ClassNotFoundException, SQLException, InvalidAppointmentId {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDBConn();
		String sql = "select exists(select appointment_id from appointment where appointment_id = ?)as value_exists";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet result = pstmt.executeQuery();
		boolean ans = false;
		if(result.next())ans = result.getBoolean("value_exists");
		if(!ans)throw new InvalidAppointmentId("Appointment ID not found enter a valid ID");
		return ans;
	}

	@Override
	public boolean patientIdExsist(int id) throws ClassNotFoundException, SQLException, PatientNumberNotFound {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDBConn();
		String sql = "select exists(select appointment_id from appointment where patient_id = ?)as value_exists";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet result = pstmt.executeQuery();
		boolean ans = false;
		if(result.next())ans = result.getBoolean("value_exists");
		if(!ans)throw new PatientNumberNotFound("Patient ID not found enter a valid ID");
		return ans;
	}

	@Override
	public boolean doctorIdExsist(int id) throws ClassNotFoundException, SQLException, InvalidDoctorId {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDBConn();
		String sql = "select exists(select doctor_id from appointment where doctor_id = ?)as value_exists";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet result = pstmt.executeQuery();
		boolean ans = false;
		if(result.next())ans =  result.getBoolean("value_exists");
		if(!ans)throw new InvalidDoctorId("Doctor ID not found enter a valid ID");
		return ans;
	}

}
