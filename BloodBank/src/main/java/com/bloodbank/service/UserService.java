package com.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.User;
import com.bloodbank.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo ur;
	
	public void saveUser(User u) {
		ur.save(u);
	}
	
	public User getUser(int id) {
		return ur.findById(id).get();
	}
}
