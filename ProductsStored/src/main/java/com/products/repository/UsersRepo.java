package com.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.products.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {
	

	@Procedure("insert_user")
	public void saveUser(int user_id,String name,String password,String type);
	
	
}
