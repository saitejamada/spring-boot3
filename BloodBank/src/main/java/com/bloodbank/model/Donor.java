package com.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donor_bloodbank")
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String mobileno;
	String email;
	String address;
	@OneToOne(cascade =CascadeType.MERGE)
	User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Donor [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", email=" + email + ", address="
				+ address + ", user=" + user + "]";
	}
	public Donor() {
		super();
	}
	public Donor(String name, String mobileno, String email, String address, User user) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.email = email;
		this.address = address;
		this.user = user;
	}
}
