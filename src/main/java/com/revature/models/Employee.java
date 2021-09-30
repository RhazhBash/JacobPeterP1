package com.revature.models;

public class Employee {
	private int ID; //Employee ID
	private String fname; //Self explanatory
	private String lname;
	private int activeTickets; //Managers can see how many tickets each employee submits
	private int totalTickets; 
	private int rejectedTickets;
	private String username; //Employee login info 
	private String password;
	private String email; //Employee email address
	private boolean isManager; //check to see if an employee has manager access
	
	
	public Employee(int iD, String fname, String lname, int activeTickets, int totalTickets, int rejectedTickets, String username,
			String password, String email, boolean isManager) {
		super();
		ID = iD;
		this.fname = fname;
		this.lname = lname;
		this.activeTickets = activeTickets;
		this.totalTickets = totalTickets;
		this.setRejectedTickets(rejectedTickets);
		this.username = username;
		this.password = password;
		this.email = email;
		this.isManager = isManager;
	}
	
	
	public Employee() {
		super();
	}


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public int getActiveTickets() {
		return activeTickets;
	}
	public void setActiveTickets(int activeTickets) {
		this.activeTickets = activeTickets;
	}
	public int getTotalTickets() {
		return totalTickets;
	}
	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}


	public int getRejectedTickets() {
		return rejectedTickets;
	}


	public void setRejectedTickets(int rejectedTickets) {
		this.rejectedTickets = rejectedTickets;
	}
	
	
	
}
