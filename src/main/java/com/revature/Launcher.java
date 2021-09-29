package com.revature;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.controllers.LoginController;
import com.revature.controllers.TicketController;
import com.revature.daos.TicketDAO;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		try(Session sess = HibernateUtil.getSession()){
			//Remember to output a connection established message somehow
			HibernateUtil.closeSession();
		} catch (HibernateException e) {
			System.out.println("hello old friend. your connection failed");
		}

		TicketController TC = new TicketController(); 
		LoginController LC = new LoginController();
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
				).start(8090);
		
		//app.get("/tickets", TC.getAllAvengersHandler);
		//This will eventually use something from the TicketController class to define the endpoint
	}
	
	
	
}
