package com.twitter.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User_twitter {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int user_id;
	@OneToOne(cascade =CascadeType.MERGE)
	Crediantails cs;
	@OneToMany(targetEntity = Posts.class,fetch = FetchType.EAGER)
	List<Posts> ps;
	int tweets;
	int followers;
	int following;
	@Lob
	byte[] image;
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public List<Posts> getPs() {
		return ps;
	}
	public void setPs(List<Posts> ps) {
		this.ps = ps;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Crediantails getCs() {
		return cs;
	}
	public void setCs(Crediantails cs) {
		this.cs = cs;
	}
	public int getTweets() {
		return tweets;
	}
	public void setTweets(int tweets) {
		this.tweets = tweets;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	public User_twitter() {
		super();
	}
	public User_twitter(Crediantails cs, List<Posts> ps, int tweets, int followers, int following) {
		super();
		this.cs = cs;
		this.ps = ps;
		this.tweets = tweets;
		this.followers = followers;
		this.following = following;
	}
	@Override
	public String toString() {
		return "User_twitter [user_id=" + user_id + ", cs=" + cs + ", ps=" + ps + ", tweets=" + tweets + ", followers="
				+ followers + ", following=" + following + "]";
	}
		
}
