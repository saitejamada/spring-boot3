package com.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.model.Crediantails;
import com.twitter.model.Posts;
import com.twitter.model.User_twitter;
import com.twitter.repository.Crediantailsrepo;
import com.twitter.repository.PostsRepo;
import com.twitter.repository.TwitterRepo;

@Service
public class TwitterService {

	@Autowired
	TwitterRepo tw;
	
	@Autowired
	PostsRepo pr;
	
	@Autowired
	Crediantailsrepo cr;
	
	public void saveDetails(User_twitter u) {
		tw.save(u);
	}
	
	public void savePosts(Posts p) {
		pr.save(p);
	}
	public void saveCrediantails(Crediantails c) {
		cr.save(c);
	}
	public List<Posts> getPosts(Crediantails c) {
		return pr.findBycs(c);
	}
	public User_twitter detUser(Crediantails c) {
		return tw.findBycs(c);
	}
	public Crediantails getcreditails(String name) {
		return cr.findByusername(name);
	}
	public List<Posts> getAllPosts() {
		return pr.findAll();
	}
	public List<Crediantails> getAllUsers(){
		return cr.findAll();
	}
	public void deleteposts(int id) {
		pr.deleteById(id);
	}
	
}
