package com.bloodbank.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_bloodbank")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int user_id;
	String username;
	String email;
	Date dob;
	String address;
	String password;
	@OneToOne(cascade = CascadeType.ALL)
	Role role;
	@OneToOne(cascade = CascadeType.ALL)
	Permission permission;
	@OneToOne(cascade = CascadeType.ALL)
	Order order;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public User() {
		super();
	}
	public User(String username, String email, Date dob, String address, String password, Role role,
			Permission permission, Order order) {
		super();
		this.username = username;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.password = password;
		this.role = role;
		this.permission = permission;
		this.order = order;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", dob=" + dob
				+ ", address=" + address + ", password=" + password + ", role=" + role + ", permission=" + permission
				+ ", order=" + order + "]";
	}
	
	
}
