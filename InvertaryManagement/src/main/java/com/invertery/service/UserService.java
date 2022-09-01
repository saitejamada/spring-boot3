package com.invertery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invertery.model.User;
import com.invertery.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	public void saveUser(User u) {
		ur.save(u);
	}
	public User getUser(int id) {
		return ur.findById(id).get();
	}
}
