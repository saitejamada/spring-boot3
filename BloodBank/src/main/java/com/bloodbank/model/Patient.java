package com.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_bloddbank")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String mobileno;
	String address;
	String email;
	String username;
	String password;
	String blood;
	String type;
	
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@OneToOne(cascade = CascadeType.MERGE)
	Permission permission;
	
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Patient(String name, String mobileno, String address, String email, String username, String password,
			Permission permission) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.permission = permission;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", address=" + address + ", email="
				+ email + ", username=" + username + ", password=" + password + ", permission=" + permission + "]";
	}
	public Patient(String name, String mobileno, String address, String email, String username, String password,
			String blood, String type, Permission permission) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.blood = blood;
		this.type = type;
		this.permission = permission;
	}
}
