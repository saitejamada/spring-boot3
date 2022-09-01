package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
