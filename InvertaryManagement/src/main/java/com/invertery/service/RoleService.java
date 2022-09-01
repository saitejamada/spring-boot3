package com.invertery.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invertery.model.Role;
import com.invertery.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository rp;
	
	public Role saveRepository(Role r) {
		return rp.save(r);
	}
	public Role getRole(int id) {
		return rp.findById(id).get();
	}
}
