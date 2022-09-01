package com.invertery.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@OneToOne(cascade = CascadeType.ALL)
	Customer c;
	String amount;
	String description;
	Date payment_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public Payment() {
		super();
	}
	
	public Payment(Customer c, String amount, String description, Date payment_date) {
		super();
		this.c = c;
		this.amount = amount;
		this.description = description;
		this.payment_date = payment_date;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", c=" + c + ", amount=" + amount + ", description=" + description + ", date="
				+ payment_date + "]";
	}
}