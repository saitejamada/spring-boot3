package com.invertery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invertery.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
