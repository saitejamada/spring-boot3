package com.twitter.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crediantails_twitter")
public class Crediantails {
	
	@Id
	String username;
	String password;
	
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
	public Crediantails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Crediantails() {
		super();
	}
	@Override
	public String toString() {
		return "Crediantails [username=" + username + ", password=" + password + "]";
	}
}
