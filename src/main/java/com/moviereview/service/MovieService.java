package com.moviereview.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moviereview.model.Movie;
@Repository
public interface MovieService {

	
	//get the data from sql
	public List<Movie> getMovieData();
	//get by id
	public List<Movie> getMovieData(Integer movieid);
	//add data to sql
	public void addMovie(Movie mve);
	//delete the data
	public void deleteMovie(String title);
	//update the data
	public void updateMovie(Movie mve);
	
	

}
