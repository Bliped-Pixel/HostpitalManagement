package com.controller;

import java.util.Scanner;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exception.*;
import com.model.*;
import com.service.HospitalService;

public class HospitalController {
	
	public static void main(String args[]) throws InvalidAppointmentId {
		
		Scanner sc = new Scanner(System.in);
		HospitalService hospitalService = new HospitalService();
		
		while(true)
		{
			
			System.out.println("Select the operation you want to perfrom: ");
			System.out.println("Press 1. To Get Appointment By ID: ");
			System.out.println("Press 2. To Get Appointment By Patient ID: ");
			System.out.println("Press 3. To Get Appointment By Doctor ID: ");
			System.out.println("Press 4. To Schedule an Appointment: ");
			System.out.println("Press 5. To Update an Appointment: ");
			System.out.println("Press 6. To Cancel an Appointment: ");
			System.out.println("Press 0. To Terminate.....");
			int choice = sc.nextInt();
			
			if(choice == 0)
			{
				System.out.println("Exiting.............");
				break;
			}
			System.out.println();
			
			switch (choice) {
			
			case 1:
				try
				{
					System.out.println("Enter the Appointment ID to Fetch from => ");
					int id = sc.nextInt();
					if(!hospitalService.appointmentIdExsist(id))break;
					Appointment appointment= hospitalService.getAppointmentById(id);
					System.out.println(appointment.toString());
				}catch (ClassNotFoundException| SQLException |InvalidAppointmentId e) {
					System.out.println(e.getMessage());
					System.out.println();
				}
				break;
				
			case 2:
				try
				{
					System.out.println("Enter the Patient Id to Fetch from => ");
					int id = sc.nextInt();
					hospitalService.patientIdExsist(id);
					List <Appointment>  patientList = hospitalService.getAppoinmentForPatient(id); 
					
					for(Appointment a : patientList)System.out.println(a.toString());
					
				}catch(ClassNotFoundException| SQLException |PatientNumberNotFound e) {
					System.out.println(e.getMessage());
					System.out.println();
				}
				break;
			case 3:
				try {
					
					System.out.println("Enter the Doctor Id to Fetch from => ");
					int id = sc.nextInt();
					if(!hospitalService.doctorIdExsist(id))break;
					List <Appointment> doctorList = hospitalService.getAppoinmentForDoctor(id); 
				
					for(Appointment a : doctorList)System.out.println(a.toString());
					
					
				}catch(ClassNotFoundException| SQLException |InvalidDoctorId e) {
					System.out.println(e.getMessage());
					System.out.println();
				}
				break;
			case 4:
				try {
					sc.nextLine();
					System.out.println("Enter the date you want to schedule your appointment in: ");
					Date appointmentDate = Date.valueOf(sc.nextLine());
					System.out.println("Enter the Patient ID: ");
					int patientId = sc.nextInt();
					System.out.println("Enter the Doctor ID: ");
					int doctorId = sc.nextInt();
					sc.nextLine();
					System.out.println("Provide a Breif Description: ");
					String description = sc.nextLine();
					
					hospitalService.scheduleAppoinment(new Appointment(patientId,doctorId,appointmentDate,description));
							
					System.out.println("Successfuly Scheduled an Appointment !");
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try
				{
					System.out.println("Enter your appointment ID => ");
					int appointmentid = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the date you want to update yout scheduled appointment if not press 0: ");
					String appointmentDate = sc.nextLine();
					System.out.println("Enter the updated Patient ID if not press 0: ");
					int patientId = sc.nextInt();
					System.out.println("Enter the updated Doctor ID if not press 0: ");
					int doctorId = sc.nextInt();
					sc.nextLine();
					System.out.println("Provide an updated Breif Description if not press 0: ");
					String description = sc.nextLine();
					Appointment appointment = hospitalService.getAppointmentById(appointmentid);
					if(!appointmentDate.equals("0"))appointment.setAppoinmentDate(Date.valueOf(appointmentDate));
					if(!(patientId == 0))appointment.setPatientId(patientId);
					if(!(doctorId == 0))appointment.setDoctorId(doctorId);
					if((!description.equals("0")))appointment.setDescription(description);
					
					hospitalService.updateAppointment(appointment);
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				try
				{
					System.out.println("Enter your Appointment ID => ");
					int appointmentId  = sc.nextInt();
					
					if(!hospitalService.appointmentIdExsist(appointmentId))break;
					
					hospitalService.cancelAppointment(appointmentId);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
		default:
			System.out.println("Invalid Operation ! Try again");
			}
		}
	}
	
	
	

}
