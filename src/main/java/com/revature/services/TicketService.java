package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.TicketDAO;
import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.utils.HibernateUtil;

public class TicketService {
	TicketDAO TDAO=new TicketDAO();
	EmployeeDAO EDAO=new EmployeeDAO();
	
	public List<Ticket> getTickets() {
		return TDAO.getTickets();
	}
	
	public List<Ticket> getActiveTickets() {
		return TDAO.getActiveTickets();
	}
	
	public List<Ticket> getTicketsByEmployee(String employee) {
		return TDAO.getTicketByEmployee(employee);
	}
	
	public List<Ticket> getActiveTicketsByEmployee(String employee) {
		return TDAO.getActiveTicketByEmployee(employee);
	}
	
	public void newTicket(Ticket ticket) {
		TDAO.newTicket(ticket);
	}
	
	public void approveTicket(int id, String resolver) {
		int EID=EDAO.IDByUsername(resolver);
		Employee emp=EDAO.getEmployeeByID(EID);
		String resolvername = emp.getFirstName() + " " + emp.getLastName();
		TDAO.acceptTicket(id, resolvername, emp);
	}
	
	public void denyTicket(int id, String resolver) {
		int EID=EDAO.IDByUsername(resolver);
		Employee emp=EDAO.getEmployeeByID(EID);
		String resolvername = emp.getFirstName() + " " + emp.getLastName();
		TDAO.denyTicket(id, resolvername, emp);
	}
}
