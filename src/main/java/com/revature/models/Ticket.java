package com.revature.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	//--------------------------------------------------------------------
	//Boilerplate code goes here
}
