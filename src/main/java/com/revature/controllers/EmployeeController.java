package com.revature.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.services.EmployeeService;

import io.javalin.http.Handler;

public class EmployeeController {
	EmployeeService ES = new EmployeeService();
	
	public Handler getAllEmployeesHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
		
			List<Employee> Employees = ES.getAllEmployees();
		
			Gson gson = new Gson();
		
			String JSONEmployees = gson.toJson(Employees); 
		
			ctx.result(JSONEmployees); 
		
			ctx.status(200); 
		}
		
		else {
			ctx.status(403); 
		}
		
	};
	
	public Handler getEmployeeByIdHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
				
			String ID = ctx.formParam("EID");
				
			int EID = Integer.parseInt(ID);
					
			Employee selectedEmployee = ES.getEmployeeById(EID); 
					
			Gson gson = new Gson();
				
			String JSONEmployees = gson.toJson(selectedEmployee); 
				
			ctx.result(JSONEmployees); 
				
			ctx.status(200); 
		}
				
		else {
			ctx.status(403); 
		}
		};
		
		public Handler hireEmployeeHandler = (ctx) -> {
			
			if(ctx.req.getSession(false) != null) {
				EmployeeDAO EDAO=new EmployeeDAO();
	
				List<Ticket> tickets=null;
				
				int id=Integer.parseInt(ctx.formParam("id"));

				Employee emp = new Employee(ctx.formParam("username"), ctx.formParam("password"), ctx.formParam("fname"), ctx.formParam("lname"), ctx.formParam("email"), false, tickets);
				ES.hireEmployee(emp);
				
			}
			else {
				ctx.status(403);
			}
		};
		
		public Handler fireEmployeeHandler = (ctx) -> {
			
			String ID = ctx.formParam("EID");
			int EID=Integer.parseInt(ID);
			
			ES.fireEmployee(EID);
			
			ctx.status(200);
			//This removes the employee but does nothing else
			//Any feedback like "John Smith successfully terminated" can go in the front end
			
		};
	
	
	//Add employee?
	//Fire employee?
	//List all employees
	//View info on a specific employee
}
