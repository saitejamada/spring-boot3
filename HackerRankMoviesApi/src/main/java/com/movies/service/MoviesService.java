package com.movies.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movies.model.Movie;
import com.movies.model.MovieResponse;

@Service
public class MoviesService {

	private RestTemplate template;

	public MoviesService(RestTemplate template) {
		super();
		this.template = template;
	}
	public MovieResponse getAllMovies() {
		String url="http://localhost:8081/movies";
		MovieResponse movies=template.getForObject(url, MovieResponse.class);
		return movies;
	}
	
	public List<Movie>  sortMovies(String title){
		String url="http://localhost:8081/movie/"+title;
		Movie movie[]=template.getForObject(url, Movie[].class);
		ArrayList al=new ArrayList<>();
		for(int i=0;i<movie.length;i++)
		{	
			al.add(movie[i].getTitle());
		}
		Collections.sort(al);
		return al;
	}
	
	
}
