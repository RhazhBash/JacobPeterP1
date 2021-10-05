package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;

public class EmployeeService {
	EmployeeDAO EDAO = new EmployeeDAO();
	
	public List<Employee> getAllEmployees() {
		return EDAO.getEmployees();
	}
	
	public Employee getEmployeeById(int ID) {
		return EDAO.getEmployeeByID(ID);
	}
	
	public void hireEmployee(Employee employee) {
		
	}
	
	public void fireEmployee(int id) {
		EDAO.youreFired(id);
	}
}
