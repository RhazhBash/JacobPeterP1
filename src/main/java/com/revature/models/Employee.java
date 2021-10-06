package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int id;

	private String username;
	private String password;
	private String fName;
	private String lName;
	private String email;
	private boolean isManager;

	
	private int submittedTickets;

	
	private int rejectedTickets;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String username, String password, String firstName, String lastName, String email,
			boolean is_manager, int submittedTickets) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fName = firstName;
		this.lName = lastName;
		this.email = email;
		this.isManager = is_manager;
		this.submittedTickets = submittedTickets;
	}

	public Employee(String username, String password, String firstName, String lastName, String email,
			boolean is_manager, int submittedTickets) {
		super();
		this.username = username;
		this.password = password;
		this.fName = firstName;
		this.lName = lastName;
		this.email = email;
		this.isManager = is_manager;
		this.submittedTickets = submittedTickets;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + fName
				+ ", lastName=" + lName + ", email=" + email + ", is_manager=" + isManager + ", submittedTickets="
				+ submittedTickets + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + id;
		result = prime * result + (isManager ? 1231 : 1237);
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + rejectedTickets;
		result = prime * result + submittedTickets;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (id != other.id)
			return false;
		if (isManager != other.isManager)
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rejectedTickets != other.rejectedTickets)
			return false;
		if (submittedTickets != other.submittedTickets)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return fName;
	}

	public void setFirstName(String firstName) {
		this.fName = firstName;
	}

	public String getLastName() {
		return lName;
	}

	public void setLastName(String lastName) {
		this.lName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIs_manager() {
		return isManager;
	}

	public void setIs_manager(boolean is_manager) {
		this.isManager = is_manager;
	}

	public int getSubmittedTickets() {
		return submittedTickets;
	}

	public void setSubmittedTickets(int submittedTickets) {
		this.submittedTickets = submittedTickets;
	}
	
	public int getRejectedTickets() {
		return submittedTickets;
	}

	public void setRejectededTickets(int rejectedTickets) {
		this.rejectedTickets = rejectedTickets;
	}

}
