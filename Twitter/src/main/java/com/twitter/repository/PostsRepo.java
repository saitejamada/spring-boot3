package com.twitter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.model.Crediantails;
import com.twitter.model.Posts;

public interface PostsRepo extends JpaRepository<Posts, Integer> {

	public List<Posts> findBycs(Crediantails c); 
}
