package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
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
	
	
	//Add employee?
	//Fire employee?
	//List all employees
	//View info on a specific employee
}
