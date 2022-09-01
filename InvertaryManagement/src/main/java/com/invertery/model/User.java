package com.invertery.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_inventory")
public class User {

	@Id
	int id;
	@OneToOne(cascade = CascadeType.ALL)
	Role r;
	String name;
	String email;
	Date dob;
	String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getR() {
		return r;
	}
	public void setR(Role r) {
		this.r = r;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User(int id, Role r, String name, String email, Date dob, String address) {
		super();
		this.id = id;
		this.r = r;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", r=" + r + ", name=" + name + ", email=" + email + ", dob=" + dob + ", address="
				+ address + "]";
	}
	public User() {
		super();
	}
}
