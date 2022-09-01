package com.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.model.Crediantails;

public interface Crediantailsrepo extends JpaRepository<Crediantails, String> {

	Crediantails findByusername(String name);

	
	
}
