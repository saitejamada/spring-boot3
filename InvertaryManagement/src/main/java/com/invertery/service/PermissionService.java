package com.invertery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invertery.model.Permission;
import com.invertery.repository.PermissionRepository;

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
