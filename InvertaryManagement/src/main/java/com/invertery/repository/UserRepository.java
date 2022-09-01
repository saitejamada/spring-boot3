package com.invertery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invertery.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
