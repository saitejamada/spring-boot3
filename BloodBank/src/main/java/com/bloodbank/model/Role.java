package com.bloodbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_bloodbank")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;
	private String role_title;
	private String role_description;
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_title() {
		return role_title;
	}
	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}
	public String getRole_description() {
		return role_description;
	}
	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
	public Role( String role_title, String role_description) {
		super();
		this.role_title = role_title;
		this.role_description = role_description;
	}
	public Role() {
		super();
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_title=" + role_title + ", role_description=" + role_description
				+ "]";
	}
	
}
