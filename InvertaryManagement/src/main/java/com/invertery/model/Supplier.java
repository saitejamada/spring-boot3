package com.invertery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String mobileno;
	String email;
	String address;
	String password;
	String username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Supplier(String name, String mobileno, String email, String address, String password, String username) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.email = email;
		this.address = address;
		this.password = password;
		this.username = username;
	}
	public Supplier() {
		super();
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", email=" + email + ", address="
				+ address + ", password=" + password + ", username=" + username + "]";
	}
	
}
