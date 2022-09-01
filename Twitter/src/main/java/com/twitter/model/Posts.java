package com.twitter.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts_twitter")
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int post_id;
	@OneToOne(cascade = CascadeType.MERGE)
	Crediantails cs;
	String post;
	
	public Crediantails getCs() {
		return cs;
	}
	@Override
	public String toString() {
		return "Posts [post_id=" + post_id + ", cs=" + cs + ", post=" + post + "]";
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public void setCs(Crediantails cs) {
		this.cs = cs;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Posts(Crediantails cs, String post) {
		super();
		this.cs = cs;
		this.post = post;
	}
	
	public Posts(int post_id, Crediantails cs, String post) {
		super();
		this.post_id = post_id;
		this.cs = cs;
		this.post = post;
	}
	public Posts() {
		super();
	}
	
}
