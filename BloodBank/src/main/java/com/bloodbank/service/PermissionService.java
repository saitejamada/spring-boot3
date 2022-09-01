package com.bloodbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Permission;
import com.bloodbank.repository.PermissionRepository;

@Service
public class PermissionService {

	@Autowired
	PermissionRepository pr;
	
	public Permission savePermission(Permission p) {
		return pr.save(p);
	}
	
	public Permission getPermission(int id) {
		return pr.findById(id).get();
	}
}
