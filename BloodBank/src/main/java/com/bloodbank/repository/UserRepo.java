package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
