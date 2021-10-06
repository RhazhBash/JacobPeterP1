package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.daos.TicketDAO;
import com.revature.models.Ticket;
import com.revature.utils.HibernateUtil;

public class TicketService {
	TicketDAO TDAO=new TicketDAO();
	
	public List<Ticket> getTickets() {
		return TDAO.getTickets();
	}
	
	public List<Ticket> getActiveTickets() {
		return TDAO.getActiveTickets();
	}
	
	public List<Ticket> getTicketsByEmployee(int EID) {
		return TDAO.getTicketByEmployee(EID);
	}
	
	public List<Ticket> getActiveTicketsByEmployee(int EID) {
		return TDAO.getActiveTicketByEmployee(EID);
	}
	
	public void newTicket(Ticket ticket) {
		TDAO.newTicket(ticket);
	}
	
	public void approveTicket(int id) {
		TDAO.acceptTicket(id);
	}
	
	public void denyTicket(int id) {
		TDAO.denyTicket(id);
	}
}
