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
    private String firstName;
    private String lastName;
    private String email;
    private boolean is_manager;
	
	
	@OneToMany(mappedBy="Author", fetch=FetchType.EAGER)
	private List<Ticket> submittedTickets;

	@OneToMany(mappedBy="Resolver", fetch=FetchType.EAGER)
	private List<Ticket> resolvedTickets;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int id, String username, String password, String firstName, String lastName, String email,
			boolean is_manager, List<Ticket> submittedTickets) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.is_manager = is_manager;
		this.submittedTickets = submittedTickets;
	}


	public Employee(String username, String password, String firstName, String lastName, String email,
			boolean is_manager, List<Ticket> submittedTickets) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.is_manager = is_manager;
		this.submittedTickets = submittedTickets;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", is_manager=" + is_manager + ", submittedTickets="
				+ submittedTickets + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + (is_manager ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((submittedTickets == null) ? 0 : submittedTickets.hashCode());
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (is_manager != other.is_manager)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (submittedTickets == null) {
			if (other.submittedTickets != null)
				return false;
		} else if (!submittedTickets.equals(other.submittedTickets))
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
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isIs_manager() {
		return is_manager;
	}


	public void setIs_manager(boolean is_manager) {
		this.is_manager = is_manager;
	}


	public List<Ticket> getSubmittedTickets() {
		return submittedTickets;
	}


	public void setSubmittedTickets(List<Ticket> submittedTickets) {
		this.submittedTickets = submittedTickets;
	}
	
}
