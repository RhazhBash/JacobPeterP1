package com.revature.services;

import com.revature.daos.EmployeeDAO;

public class LoginService {

	EmployeeDAO eDAO = new EmployeeDAO();
	public boolean login(String username, String password) {
		
		if(eDAO.validate(username, password)) {
			return true;
		}
		
		return false;
		
		//Implement EmployeeDAO to do login service
		//Potentially loop through the whole users table to check for a match?
	}
	
}
