package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

import com.google.gson.Gson;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.services.TicketService;
import com.revature.services.EmployeeService;

import io.javalin.http.Handler;

public class TicketController {
	TicketService TS = new TicketService();
	EmployeeService ES = new EmployeeService();
	
	public Handler getAllTicketsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
		
			List<Ticket> Tickets = TS.getTickets();
		
			Gson gson = new Gson();
		
			String JSONTickets = gson.toJson(Tickets); 
		
			ctx.result(JSONTickets); 
		
			ctx.status(200); 
		}
		
		else {
			ctx.status(403); 
		}
		
	};
	
	public Handler getActiveTicketsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
			List<Ticket> activeTickets = TS.getActiveTickets();
			
			Gson gson = new Gson();
		
			String JSONTickets = gson.toJson(activeTickets); 
		
			ctx.result(JSONTickets); 
		
			ctx.status(200); 
		}
		
		else {
			ctx.status(403); 
		}
		};
		
	public Handler getActiveTicketsByEmployeeHandler = (ctx) -> {
			
		if(ctx.req.getSession(false) != null) {
			
			String Employee = ctx.queryParam("EID");
			System.out.println(Employee);
			int EID = Integer.valueOf(Employee);
				
			List<Ticket> activeTicketsByEmployee = TS.getActiveTicketsByEmployee(EID); 
				
			Gson gson = new Gson();
			
			String JSONTickets = gson.toJson(activeTicketsByEmployee); 
			
			ctx.result(JSONTickets); 
			
			ctx.status(200); 
		}
			
		else {
			ctx.status(403); 
		}
		};
		
	public Handler getTicketsByEmployeeHandler = (ctx) -> {
			
		if(ctx.req.getSession(false) != null) {
				
			String Employee = ctx.queryParam("EID");
			
			int EID = Integer.valueOf(Employee);
					
			List<Ticket> ticketsByEmployee = TS.getTicketsByEmployee(EID); 
					
			Gson gson = new Gson();
				
			String JSONTickets = gson.toJson(ticketsByEmployee); 
				
			ctx.result(JSONTickets); 
				
			ctx.status(200); 
		}
				
		else {
			ctx.status(403); 
		}
		};
		
		//The body of the post request should look like this
		//{"Amount":<Money requested>, "Description":"<User inputed message>", "Status":"0", "Type":"<Chosen from 4 options>", "Author":{"id":<Employee ID>}}
		public Handler newTicketHandler = (ctx) -> {
			if(ctx.req.getSession(false) != null) {
				
				String body=ctx.body();
				Date newDate=new Date();
				Gson gson=new Gson();
				
				Ticket ticket=gson.fromJson(body, Ticket.class);
				
				long date=newDate.getTime();
				Timestamp tstmp=new Timestamp(date);
				ticket.setSubmitted(tstmp);
				Employee emp=ES.getEmployeeById(ticket.getAuthor().getId());
	
				//ES.incrementTickets(emp);
			
				ticket.setAuthor(emp);
				
				
				TS.newTicket(ticket);
				
				ctx.status(200);
 
			}
			else {
				ctx.status(403);
			}
		};
		public Handler approveTicketHandler = (ctx) -> {
			if(ctx.req.getSession(false) != null) {
				
				String TID = ctx.queryParam("TID");
				int ID = Integer.valueOf(TID);
				TS.approveTicket(ID);
			}
			
			else {
				ctx.status(403); 
			}
		};
		public Handler denyTicketHandler = (ctx) -> {
			if(ctx.req.getSession(false) != null) {
				
				String TID = ctx.queryParam("TID");
				int ID = Integer.valueOf(TID);
				TS.denyTicket(ID);
}
			
			else {
				ctx.status(403); 
			}
		};
}