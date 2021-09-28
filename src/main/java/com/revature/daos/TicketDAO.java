package com.revature.daos;

import java.util.List;

import com.revature.models.Ticket;

import com.revature.utils.HibernateUtil;

public class TicketDAO implements TicketDAOInterface {

	@Override
	public List<Ticket> getTickets() {
		Session ses = HibernateUtil.getSession();
		
		List<Ticket> ticketList = ses.createQuery("FROM Ticket").list();
		
		HibernateUtil.closeSession();
		
		return ticketList;
	}

	@Override
	public List<Ticket> getActiveTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketByEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getActiveTicketByEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void newTicket(Ticket newTicket) {
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(newTicket); 
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public void confirmTicket() {
		// TODO Auto-generated method stub
		
	}

}
