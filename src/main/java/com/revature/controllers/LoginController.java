package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.models.LoginDTO;
import com.revature.services.EmployeeService;
import com.revature.services.LoginService;
import com.revature.utils.JWTUtil;

import io.javalin.http.Handler;

public class LoginController {
	
	LoginService ls = new LoginService();

	public Handler loginHandler = (ctx) -> {
		
		//Body of the post request should look like this
		//{"username":<user submitted input>, "password":"<User submitted input>"}
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		if(ls.login(LDTO.getUsername(), LDTO.getPassword())) {
			
			
			String jwt = JWTUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			
			ctx.req.getSession(); 
			
		
			ctx.status(200);
			
			ctx.result("Successfully logged in with token "+ jwt);
			
		} else {
			
			ctx.status(401); 
			ctx.result("Invalid username/password");
			
		}
	};
	//------------------------------------------------
		
	public Handler mloginHandler = (ctx) -> {
		
		//Body of the post request should look like this
		//{"username":<user submitted input>, "password":"<User submitted input>"}
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		EmployeeService ES = new EmployeeService();
        int incomingID = ES.getIDByUsername(LDTO.getUsername());
        Employee emp = ES.getEmployeeById(incomingID);
        boolean isManager = emp.getis_manager();
		
        if (isManager == false) {
			ctx.status(401); 
			ctx.result("Not a manager");
        } else if (ls.login(LDTO.getUsername(), LDTO.getPassword())) {
			
			
			String jwt = JWTUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			
			ctx.req.getSession(); 
			
		
			ctx.status(200);
			
			ctx.result("Successfully logged in with token "+ jwt);
			
		} else {
			
			ctx.status(401); 
			ctx.result("Invalid username/password");
			
		}
	};
	
	
	
	
	
	
	
}
