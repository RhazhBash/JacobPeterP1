package com.revature.services;

import java.util.List;

import com.revature.daos.TicketDAO;
import com.revature.models.Ticket;

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
}
