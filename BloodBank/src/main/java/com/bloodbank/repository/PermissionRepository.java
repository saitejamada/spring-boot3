package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{

}
