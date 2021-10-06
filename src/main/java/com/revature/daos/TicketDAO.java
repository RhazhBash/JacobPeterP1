package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
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

	@SuppressWarnings("null")
	@Override
	public List<Ticket> getActiveTickets() {
		
		//Gets the full list of tickets and sorts active ones into a separate list
		List<Ticket> ticketList=getTickets();
		List<Ticket> activeTickets = null;
		
		for (int i=0; i<ticketList.size(); i++) {
			
			Ticket temp=ticketList.get(i);
			int status=temp.getStatus();
			if (status==0)
				activeTickets.add(temp);
		}
		
		return activeTickets;
	}

	@SuppressWarnings("null")
	@Override
	public List<Ticket> getTicketByEmployee(int EID) {
		
		//Same code as getActiveTickets except it sorts by employee ID
		List<Ticket> ticketList=getTickets();
		List<Ticket> employeeTickets = null;
		
		for (int i=0; i<ticketList.size(); i++) {
			
			Ticket temp=ticketList.get(i);
			if (EID==temp.getAuthor().getId())
				employeeTickets.add(temp);
		}
		
		return employeeTickets;
	}

	@SuppressWarnings("null")
	@Override
	public List<Ticket> getActiveTicketByEmployee(int EID) {
		
		//Combines the two methods above
		List<Ticket> ticketList=getTickets();
		List<Ticket> activeTickets = null;
		
		for (int i=0; i<ticketList.size(); i++) {
			
			Ticket temp=ticketList.get(i);
			int status=temp.getStatus();
			if (status==0&&temp.getAuthor().getId()==EID)
				activeTickets.add(temp);
		}
		
		return activeTickets;
	}

	@Override
	public void newTicket(Ticket newTicket) {
		
		Employee emp = newTicket.getAuthor();
		
		//List<Ticket> submittedTickets=getTicketByEmployee(emp.getId()); 
		
		//submittedTickets.add(newTicket);
		
		Session ses = HibernateUtil.getSession(); 
		
		ses.save(newTicket); 
		//ses.save(submittedTickets);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public void acceptTicket(int TID) {
		
		//Takes a ticket ID and sets status to accepted
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		String HQL = "UPDATE Ticket SET status = '1' WHERE id = " + TID;
		
		Query q = ses.createQuery(HQL);
		
		q.executeUpdate();
		
		tran.commit();
		
		HibernateUtil.closeSession();
		
	}
	
	@Override
	public void denyTicket(int TID) {
		
		//Takes a ticket ID and sets status to denied
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		String HQL = "UPDATE Ticket SET status = '-1' WHERE id = " + TID;
		
		Query q = (Query) ses.createQuery(HQL);
		
		q.executeUpdate();
		
		tran.commit();
		
		HibernateUtil.closeSession();
		
	}

}
