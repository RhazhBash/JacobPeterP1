package com.revature.daos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Ticket;
import com.revature.utils.HibernateUtil;

public class TicketDAO implements TicketDAOInterface {

	@Override
	public List<Ticket> getTickets() {
		Session ses = HibernateUtil.getSession();
		
		List<Ticket> ticketList = ses.createQuery("FROM Ticket").list();
		
		for (int i=0; i<ticketList.size(); i++) {
			Ticket temp=ticketList.get(i);
			//String resolvername = temp.getResolver().getFirstName() + " " + temp.getResolver().getLastName();
			//temp.setResolver_name(resolvername);
		}
		
		HibernateUtil.closeSession();
		
		return ticketList;
	}

	@SuppressWarnings("null")
	@Override
	public List<Ticket> getActiveTickets() {
		
		//Gets the full list of tickets and sorts active ones into a separate list
		List<Ticket> ticketList=getTickets();
		ArrayList<Ticket> activeTickets = new ArrayList<Ticket>();
		
		for (int i=0; i<ticketList.size(); i++) {
			
			Ticket temp=ticketList.get(i);
			int status=temp.getStatus();
			if (status==0)
				activeTickets.add(temp);
		}
		
		return activeTickets;
	}


	@Override
	public List<Ticket> getTicketByEmployee(String Employee) {
		
		//Same code as getActiveTickets except it sorts by employee ID
		List<Ticket> ticketList=getTickets();
		ArrayList<Ticket> employeeTickets = new ArrayList<Ticket>();
		
		if (Employee != null) {
			for (int i = 0; i < ticketList.size(); i++) {

				Ticket temp = ticketList.get(i);
				if (Employee.equals(temp.getAuthor().getUsername())) {
					if (temp.getStatus()!=0) {
						String resolvername = temp.getResolver().getFirstName() + " " + temp.getResolver().getLastName();
						temp.setResolver_name(resolvername);
					}
					employeeTickets.add(temp);
				}
			}
		}
		return employeeTickets;
	}

	@SuppressWarnings("null")
	@Override
	public List<Ticket> getActiveTicketByEmployee(String Employee) {
		
		//Combines the two methods above
		List<Ticket> ticketList=getTickets();
		ArrayList<Ticket> activeTickets = new ArrayList<Ticket>();
		
		for (int i=0; i<ticketList.size(); i++) {
			
			Ticket temp=ticketList.get(i);
			int status=temp.getStatus();
			if (status==0&&Employee.equals(temp.getAuthor().getUsername()))
				activeTickets.add(temp);
		}
		
		return activeTickets;
	}

	@Override
	public void newTicket(Ticket newTicket) {
		
		//System.out.println(newTicket.getAuthor().getSubmittedTickets());
		
		//Employee emp = newTicket.getAuthor();
		//System.out.println(emp);
		
		Session ses = HibernateUtil.getSession(); 
		
		//ses.update(emp);
		ses.save(newTicket); 
		//ses.save(submittedTickets);
		
		HibernateUtil.closeSession();
		
		/*Session ses2 = HibernateUtil.getSession();
		ses2.update(emp);
		HibernateUtil.closeSession();*/
		
	}

	@Override
	public void acceptTicket(int TID, String name, Employee emp) {
		Date date = new Date();
		Timestamp tstmp = new Timestamp(date.getTime());
		//Takes a ticket ID and sets status to accepted
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		String HQL = "UPDATE Ticket SET status = 1 WHERE id = " + TID;
		String HQL2 = "UPDATE Ticket SET resolver_name = '" + name + "' WHERE id = " + TID;
		String HQL3 = "UPDATE Ticket SET resolved = '" + tstmp + "' WHERE id = " + TID;
		String HQL4 = "UPDATE Ticket SET resolver_id = " + emp.getId() + "WHERE id = " + TID;
		
		Query q = ses.createQuery(HQL);
		Query q2 = ses.createQuery(HQL2);
		Query q3 = ses.createQuery(HQL3);
		Query q4 = ses.createQuery(HQL4);
		
		q.executeUpdate();
		q2.executeUpdate();
		q3.executeUpdate();
		q4.executeUpdate();
		
		tran.commit();
		
		HibernateUtil.closeSession();
		
	}
	
	@Override
	public void denyTicket(int TID, String name, Employee emp) {
		Date date = new Date();
		Timestamp tstmp = new Timestamp(date.getTime());
		//Takes a ticket ID and sets status to denied
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		String HQL = "UPDATE Ticket SET status = -1 WHERE id = " + TID;
		String HQL2 = "UPDATE Ticket SET resolver_name = '" + name + "' WHERE id = " + TID;
		String HQL3 = "UPDATE Ticket SET resolved = '" + tstmp + "' WHERE id = " + TID;
		String HQL4 = "UPDATE Ticket SET resolver_id = " + emp.getId() + "WHERE id = " + TID;
		
		
		Query q = ses.createQuery(HQL);
		Query q2 = ses.createQuery(HQL2);
		Query q3 = ses.createQuery(HQL3);
		Query q4 = ses.createQuery(HQL4);
		
		q.executeUpdate();
		q2.executeUpdate();
		q3.executeUpdate();
		q4.executeUpdate();
		
		tran.commit();
		
		HibernateUtil.closeSession();
		
	}

}
