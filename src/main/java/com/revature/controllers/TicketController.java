package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Ticket;
import com.revature.services.TicketService;

import io.javalin.http.Handler;

public class TicketController {
	TicketService TS = new TicketService();
	
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
			
			String Employee = ctx.formParam("EID");
			
			int EID = Integer.parseInt(Employee);
				
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
				
			String Employee = ctx.formParam("EID");
				
			int EID = Integer.parseInt(Employee);
					
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
		
		public Handler newTicketHandler = (ctx) -> {
			if(ctx.req.getSession(false) != null) {
				
			}
			else {
				ctx.status(403);
			}
		};
			
			
}
