package com.moviereview.service;

import java.util.List;

import com.moviereview.model.Movies;

public interface MoviesService {

	public List<Movies> getMoviesData();
	public List<Movies> getMoviesData(String genre);
}
