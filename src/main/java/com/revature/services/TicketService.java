package com.revature.services;

import java.util.List;

import com.revature.daos.TicketDAO;
import com.revature.models.Ticket;

public class TicketService {
	TicketDAO TDAO=new TicketDAO();
	
	public List<Ticket> getTickets() {
		return TDAO.getTickets();
	}
}
