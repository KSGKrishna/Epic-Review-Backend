package com.moviereview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviereview.model.Movie;
import com.moviereview.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MovieController {
	@Autowired
	private MovieService mveservice;
	
	//get data from sql
	@GetMapping("/allmovies")
	public List<Movie> getMovie(){
		return this.mveservice.getMovieData();
	}
	//get by id

	@RequestMapping(value = "/getmovie/{movieid}", method = RequestMethod.GET)
	public List<Movie> getMovieData(@PathVariable("movieid") Integer movieid) {
		return mveservice.getMovieData(movieid);
	}
	
	//add data into sql
	@PostMapping(value="/addmovie")
	public void addMovie(@RequestBody Movie mve) {
		mveservice.addMovie(mve);
		
	}
	
	//delete data
	@RequestMapping(method=RequestMethod.DELETE,value="/deletemovie/{title}")
	public void deleteUser(@PathVariable String title)
	{
		mveservice.deleteMovie(title);
	}
	//update data
	@PutMapping(value="/updatemovie")
	public void updateMovie(@RequestBody Movie mve)
	{
		mveservice.updateMovie(mve);
	}
}
