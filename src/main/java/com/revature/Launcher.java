package com.revature;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.TicketController;
import com.revature.daos.TicketDAO;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

		TicketController TC = new TicketController(); 
		LoginController LC = new LoginController();
		EmployeeController EC = new EmployeeController();
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
				).start(8090);
		
		
		app.get("/tickets", TC.getAllTicketsHandler);
		app.get("/tickets/employee", TC.getTicketsByEmployeeHandler);
		app.get("/tickets/active", TC.getActiveTicketsHandler);
		app.get("/tickets/active/employee", TC.getActiveTicketsByEmployeeHandler);
		app.post("/tickets/approve", TC.approveTicketHandler);
		app.post("/tickets/deny", TC.denyTicketHandler);
		app.post("/tickets/new", TC.newTicketHandler);
		app.post("/login", LC.loginHandler);
		app.post("/mlogin", LC.mloginHandler);
		app.get("/employees", EC.getAllEmployeesHandler);
		app.get("/employees/id", EC.getEmployeeByIdHandler);
		app.get("/employees/username", EC.getIDByUsernameHandler);
	}
	
	
	
}
