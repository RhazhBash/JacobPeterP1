package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.revature.models.Employee;
import com.revature.utils.HibernateUtil;

public class EmployeeDAO {

	public void addEmployeee(Employee employee) {
		
		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a Connection with JDBC
		
		ses.save(employee); 
		
		HibernateUtil.closeSession();
		
		//This is the ENTIRE insert method - much cleaner than JDBC :)
		//no try/catch? well, we aren't really writing any SQL that could go wrong. Simply using sessions methods
		
	}

	public List<Employee> getAllEmployees() {

		Session ses = HibernateUtil.getSession();

		// Using HQL! Hibernate Query Language. It references Java Classes, not DB
		// entities
		List<Employee> employeeList = ses.createQuery("FROM Employee").list();

		HibernateUtil.closeSession();

		return employeeList;

	}
	
	public Employee findMovieById(int id){
		
		Session ses = HibernateUtil.getSession();
		
		Employee employee = ses.get(Employee.class, id);
		
		HibernateUtil.closeSession();
		
		return employee;
		
	}
	
	
	public boolean validate(String userName, String password) {

		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			String HQL = "FROM Employee U WHERE U.username = :userName";
			employee = (Employee) session.createQuery(HQL).setParameter("userName", userName).uniqueResult();

			if (employee != null && employee.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

}