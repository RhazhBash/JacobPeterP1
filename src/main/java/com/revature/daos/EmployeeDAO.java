package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.revature.models.Employee;
import com.revature.utils.HibernateUtil;

public class EmployeeDAO {

	public void saveUser(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Employee> getAllEmployees() {

		Session ses = HibernateUtil.getSession();

		// Using HQL! Hibernate Query Language. It references Java Classes, not DB
		// entities
		List<Employee> employeeList = ses.createQuery("FROM Employee").list();

		HibernateUtil.closeSession();

		return employeeList;

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