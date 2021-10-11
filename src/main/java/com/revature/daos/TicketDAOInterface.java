package com.revature.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Ticket;
import com.revature.models.Employee;

public interface TicketDAOInterface {
	
	public List<Ticket> getTickets(); //In case we need to use all the tickets
	
	public List<Ticket> getActiveTickets(); //For managers to view active tickets
	
	public List<Ticket> getTicketByEmployee(String Employee); //Outputs all tickets from a given employee
	
	public List<Ticket> getActiveTicketByEmployee(String Employee); //For employees to view their pending tickets
	
	public void newTicket(Ticket newTicket); //Submits a new reimbursement request
	
	public void acceptTicket(int TID, String username, Employee emp); //Managers use this to approve/deny a ticket
	
	public void denyTicket(int TID, String username, Employee emp);
	
}
