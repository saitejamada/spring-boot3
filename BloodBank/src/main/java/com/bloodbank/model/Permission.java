package com.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permission_bloodbank")
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String title;
	@OneToOne(cascade = CascadeType.ALL)
	Role role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Permission(String title, Role role) {
		super();
		this.title = title;
		this.role = role;
	}
	public Permission() {
		super();
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", title=" + title + ", role=" + role + "]";
	}
	
}
