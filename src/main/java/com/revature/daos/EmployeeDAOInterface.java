package com.revature.daos;

import java.util.List;
import com.revature.models.Employee;

public interface EmployeeDAOInterface {

	public void newEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public boolean validate(String username, String password);
	
	public Employee getEmployeeByID(int EID);
	
	public void youreFired(int id);
	
}
