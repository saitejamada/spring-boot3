package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Credientials;


public interface CredientailsRepo extends JpaRepository<Credientials, String> {

	//it will fetech credientails based on username
	 public Credientials findByuserName(String username);

}
