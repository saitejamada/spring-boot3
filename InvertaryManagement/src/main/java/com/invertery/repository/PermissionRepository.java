package com.invertery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invertery.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
