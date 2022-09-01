package com.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Role;
import com.bloodbank.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository rp;
	
	public void saveRole(Role r) {
		rp.save(r);
	}
	public Role getRole(int id) {
		return rp.findById(id).get();
	}
}
