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
	@JoinColumn(name = "employee_id")
    private Employee Author;
    
	//Assign an employee as the manager of the ticket
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name = "employee_id")
    private Employee Resolver;

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
		this.TID = id;
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

	@Override
	public String toString() {
		return "Ticket [id=" + TID + ", Amount=" + Amount + ", Submitted=" + Submitted + ", Resolved=" + Resolved
				+ ", Description= " + Description +
				", Author ID & Name: " + Author.getId() + " " + Author.getFirstName() + " " + Author.getLastName() + 
				", Resolved by: " + Resolver.getId() + " " + Resolver.getFirstName() + " " + Resolver.getLastName() +
				", Status= " + Status +
				", Type= " + Type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Author == null) ? 0 : Author.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((Resolved == null) ? 0 : Resolved.hashCode());
		result = prime * result + ((Resolver == null) ? 0 : Resolver.hashCode());
		result = prime * result + Status;
		result = prime * result + ((Submitted == null) ? 0 : Submitted.hashCode());
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
		result = prime * result + TID;
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
		if (Author == null) {
			if (other.Author != null)
				return false;
		} else if (!Author.equals(other.Author))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (Resolved == null) {
			if (other.Resolved != null)
				return false;
		} else if (!Resolved.equals(other.Resolved))
			return false;
		if (Resolver == null) {
			if (other.Resolver != null)
				return false;
		} else if (!Resolver.equals(other.Resolver))
			return false;
		if (Status != other.Status)
			return false;
		if (Submitted == null) {
			if (other.Submitted != null)
				return false;
		} else if (!Submitted.equals(other.Submitted))
			return false;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		if (TID != other.TID)
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
