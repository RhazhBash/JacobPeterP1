package com.revature.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.annotations.Table;

public class Ticket {
	
	private int TID; //Ticket ID
	private int EID; //ID of the employee submitting the ticket
	private String fname; //These should be self explanatory
	private String lname;
	private String type; //Lodging, travel, food, or other
	private Double amount; //How much money was requested
	private Double reimbursement; //How much was given to the employee
	private String status; //Accepted, denied, pending, or documentation required
	
	//Pending is the default value for status, and a finance manager has to manually change it
	
	private String employeeDescription; //Employees must provide a brief description of why they're making the ticket
	private String managerNotes; //For managers to give a reason for approving/denying a ticket
	private String email; //Email address of the person making the ticket
	private static final SimpleDateFormat timeSubmitted=new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss"); //Timestamps for opening/closing a ticket
	private static final SimpleDateFormat timeClosed=new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");
	private String manager; //Name of the manager who handled the ticket, set upon first manager action taken
	
	
	
	public Ticket(int tID, int eID, String fname, String lname, String type, Double amount, Double reimbursement,
			String status, String employeeDescription, String managerNotes, String email, String manager) {
		super();
		TID = tID;
		EID = eID;
		this.fname = fname;
		this.lname = lname;
		this.type = type;
		this.amount = amount;
		this.reimbursement = reimbursement;
		this.status = status;
		this.employeeDescription = employeeDescription;
		this.managerNotes = managerNotes;
		this.email = email;
		this.manager = manager;
	}
	
	public Ticket() {
		super();
	}



	public int getTID() {
		return TID;
	}
	public void setTID(int tID) {
		TID = tID;
	}
	public int getEID() {
		return EID;
	}
	public void setEID(int eID) {
		EID = eID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getReimbursement() {
		return reimbursement;
	}
	public void setReimbursement(Double reimbursement) {
		this.reimbursement = reimbursement;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmployeeDescription() {
		return employeeDescription;
	}
	public void setEmployeeDescription(String employeeDescription) {
		this.employeeDescription = employeeDescription;
	}
	public String getManagerNotes() {
		return managerNotes;
	}
	public void setManagerNotes(String managerNotes) {
		this.managerNotes = managerNotes;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public static SimpleDateFormat getTimesubmitted() {
		return timeSubmitted;
	}
	public static SimpleDateFormat getTimeclosed() {
		return timeClosed;
	}
}
