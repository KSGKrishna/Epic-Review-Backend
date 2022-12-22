package com.moviereview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.model.Movies;
import com.moviereview.service.MoviesService;
@RestController
public class MoviesController {
	@Autowired
	private MoviesService mvservice;
	
	//get data from sql
	@GetMapping("/movies")
	public List<Movies> getMovies(){
		return this.mvservice.getMoviesData();
	}
	@RequestMapping(value = "/movies/{genre}", method = RequestMethod.GET)
	public List<Movies> getMovies(@PathVariable("genre") String genre) {
		return mvservice.getMoviesData(genre);
	}
}
