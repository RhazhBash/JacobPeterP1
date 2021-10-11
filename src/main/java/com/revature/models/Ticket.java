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
	private int TID; //Ticket ID
	
	@Column(name= "ticket_amount")
    private double Amount;
	
	//private static final SimpleDateFormat timeSubmitted=new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss"); //Timestamps for opening/closing a ticket
	//private static final SimpleDateFormat timeClosed=new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");
    private Timestamp Submitted;
    private Timestamp Resolved;
    private String Description;
    
    
    
    //Assign an employee as the author of the ticket
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee Author;
	//Assign an employee as the manager of the ticket
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name = "resolver_id", referencedColumnName = "employee_id")
    private Employee Resolver;
	
	private String Resolver_name;

    //-1 refused, 0 not resolved, 1 accepted
    private int Status;
    private String Type;
    
    
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(int id, double amount, Timestamp submitted, Timestamp resolved, String description, Employee author,
			Employee resolver, String Resolver_name, int status, String type) {
		super();
		this.TID = id;
		this.Amount = amount;
		this.Submitted = submitted;
		this.Resolved = resolved;
		this.Description = description;
		this.Author = author;
		this.Resolver = resolver;
		this.setResolver_name(Resolver_name);
		this.Status = status;
		this.Type = type;
	}



	public Ticket(double amount, Timestamp submitted, Timestamp resolved, String description, Employee author,
			Employee resolver, String Resolver_name, int status, String type) {
		super();
		this.Amount = amount;
		this.Submitted = submitted;
		this.Resolved = resolved;
		this.Description = description;
		this.Author = author;
		this.Resolver = resolver;
		this.setResolver_name(Resolver_name);
		this.Status = status;
		this.Type = type;
	}

	//Initially tickets are always status 0, no resolver and no resolved
	public Ticket(double amount, Timestamp submitted, String description, Employee author, String type) {
		super();
		this.Amount = amount;
		this.Submitted = submitted;
		this.Status = 0;
		this.Description = description;
		this.Author = author;
		this.Type = type;
	}
	
	
	@Override
	public String toString() {
		String base =  "Ticket [id=" + TID + ", Amount=" + Amount + ", Submitted= " + Submitted + 
				" Description= " + Description + 
				", Author ID & Name: " + Author.getId() + " " + Author.getFirstName() + " " + Author.getLastName();
		
		//checks for resolution to prevent null exception
		if (this.Resolver != null) {
			base +=" Resolved by: " + Resolver_name +
					"Resolved= " + Resolved	;
		}
		base += ", Status= " + Status +
				", Type= " + Type + "]";
		
		return base;
	}


	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + Status;
		result = prime * result + ((Submitted == null) ? 0 : Submitted.hashCode());
		result = prime * result + TID;
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
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
		Ticket other = (Ticket) obj;
		if (Double.doubleToLongBits(Amount) != Double.doubleToLongBits(other.Amount))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Status != other.Status)
			return false;
		if (Submitted == null) {
			if (other.Submitted != null)
				return false;
		} else if (!Submitted.equals(other.Submitted))
			return false;
		if (TID != other.TID)
			return false;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		return true;
	}

	public int getId() {
		return TID;
	}

	public void setId(int id) {
		this.TID = id;
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
		if(Author != null) {
			return Author;
		}
		return new Employee();
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

	public String getResolver_name() {
		return Resolver_name;
	}

	public void setResolver_name(String resolver_name) {
		Resolver_name = resolver_name;
	}
	
    
    
    
    

}
