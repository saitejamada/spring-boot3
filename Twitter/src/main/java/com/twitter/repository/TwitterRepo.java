package com.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.model.Crediantails;
import com.twitter.model.User_twitter;

public interface TwitterRepo extends JpaRepository<User_twitter, Integer> {

	public User_twitter findBycs(Crediantails c);

}
