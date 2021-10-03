package com.revature.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tickets")
public class Ticket {
	
	
	
	@Id //This makes this field the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This will make our PK serial
	@Column(name = "ticket_id")
	private int id; //Ticket ID
	
	@Column(name= "ticket_amount")
    private double Amount;
	
    private Timestamp Submitted;
    private Timestamp Resolved;
    private String Description;
    
    
    
    //Assign an employee as the author of the ticket
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name = "employee_id")
    private Employee author;
    
	//Assign an employee as the manager of the ticket
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name = "employee_id")
    private Employee resolver;

    //-1 refused, 0 not resolved, 1 acccepted
    private int Status;
    private String Type;
    
    
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(int id, double amount, Timestamp submitted, Timestamp resolved, String description, Employee author,
			Employee resolver, int status, String type) {
		super();
		this.id = id;
		Amount = amount;
		Submitted = submitted;
		Resolved = resolved;
		Description = description;
		Author = author;
		Resolver = resolver;
		Status = status;
		Type = type;
	}



	public Ticket(double amount, Timestamp submitted, Timestamp resolved, String description, Employee author,
			Employee resolver, int status, String type) {
		super();
		Amount = amount;
		Submitted = submitted;
		Resolved = resolved;
		Description = description;
		Author = author;
		Resolver = resolver;
		Status = status;
		Type = type;
	}

	
	//Call the author and resolver employees IDs and names rather than the object directly to avoid a loop from their ticket list
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", Amount=" + Amount + ", Submitted=" + Submitted + ", Resolved=" + Resolved
				+ ", Description= " + Description +
				", Author ID & Name: " + Author.getId() + " " + Author.getFirstName() + " " + Author.getLastName() + 
				", Resolved by: " + Resolver.getId() + " " + Resolver.getFirstName() + " " + Resolver.getLastName() +
				", Status= " + Status +
				", Type= " + Type + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public Timestamp getSubmitted() {
		return Submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		Submitted = submitted;
	}

	public Timestamp getResolved() {
		return Resolved;
	}

	public void setResolved(Timestamp resolved) {
		Resolved = resolved;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Employee getAuthor() {
		return Author;
	}

	public void setAuthor(Employee author) {
		Author = author;
	}

	public Employee getResolver() {
		return Resolver;
	}

	public void setResolver(Employee resolver) {
		Resolver = resolver;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
    
    
    
    

}
