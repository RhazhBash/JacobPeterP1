package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.daos.EmployeeDAOInterface;

import com.revature.models.Employee;
import com.revature.utils.HibernateUtil;

public class EmployeeDAO implements EmployeeDAOInterface{

	public void newEmployee(Employee employee) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSession();
		// start a transaction
		transaction = session.beginTransaction();
		// save the student object
		session.save(employee);
		// commit transaction
		transaction.commit();
		HibernateUtil.closeSession();
	}

	@SuppressWarnings("unchecked")      
	public List<Employee> getEmployees() {

        Session ses = HibernateUtil.getSession();

        List<Employee> employeeList = ses.createQuery("FROM Employee").list();

        HibernateUtil.closeSession();

        return employeeList;

    }
	
	
	//This method should be in a separate LoginDAO class, but idk if it's necessary to make a new class for one method
	public boolean validate(String username, String password) {

		List<Employee> employees = getEmployees();
		
		for (int i=0; i<employees.size(); i++) {
			Employee temp = employees.get(i);
			if (username.equals(temp.getUsername())&&password.equals(temp.getPassword()))
				return true;
		}
		
		return false;
		
		//Potentially loop through the whole users table to check for a match?
		//Potentially return an employee instead of a bool?
	}
	
	public Employee getEmployeeByID(int EID) {
		List<Employee> employeeList=getEmployees();
		Employee emp = new Employee();
		
		for (int i=0; i<employeeList.size(); i++) {
			
			Employee temp=employeeList.get(i);
			int ID=temp.getId();
			if (ID==EID)
				return temp;
		}
		//Add code to notify user if an ID isn't found later
		return null;
	}
	
	public void youreFired(int id)
	{
	    Session session ;
	    Employee Employee ;

	    session = HibernateUtil.getSession();
	    Employee = (Employee)session.load(Employee.class,id);
	    session.delete(Employee);

	    //This makes the pending delete to be done
	    session.flush() ;

	}
	

}
