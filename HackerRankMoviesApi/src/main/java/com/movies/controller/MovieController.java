package com.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movies.model.Movie;
import com.movies.model.MovieResponse;
import com.movies.service.MoviesService;

@RestController
public class MovieController {
	
	@Autowired
	MoviesService service;

	@GetMapping("/movies")
	public MovieResponse getAllMovies() {
		return service.getAllMovies();
	}
	
	@GetMapping("/movie/{Title}")
	public List getSortMovie(@PathVariable("Title") String title) {
		return service.sortMovies(title);
	}
}
