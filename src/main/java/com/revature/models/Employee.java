package com.revature.models;

public class Employee {
	private int ID; //Employee ID
	private String fname; //Self explanatory
	private String lname;
	private int activeTickets; //Managers can see how many tickets each employee submits
	private int totalTickets; 
	private String username; //Employee login info 
	private String password;
	private String email; //Employee email address
	private boolean isManager; //check to see if an employee has manager access
	
	/*NOTE:Database will differentiate between managers and non managers.
	 Upon login a check is performed to send the user to either the employee or manager page.
	 */
	
	//Add method for employee to make a new ticket
	//Add method for employee to view their active tickets
	//Add method for employee to view past tickets
	//Potentially combine the last two methods?
	
	//-----------------------------------------------
	//Boilerplate code goes below
	
}
