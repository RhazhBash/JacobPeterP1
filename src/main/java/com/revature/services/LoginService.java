package com.revature.services;

public class LoginService {

	public boolean login(String username, String password) {
		
		if(username.equals("ben") && password.equals("password")) {
			return true;
		}
		
		return false;
		
		//Implement EmployeeDAO to do login service
		//Potentially loop through the whole users table to check for a match?
	}
	
}
