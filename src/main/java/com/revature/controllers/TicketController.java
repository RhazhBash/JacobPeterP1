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
		
		} else {
			ctx.status(403); 
		}
		
	};
}
