package com.moviereview.EpicReviews.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.moviereview.model.Movie;
import com.moviereview.service.MovieService;
import com.moviereview.serviceimpl.MovieServiceImpl;



	@RunWith(SpringRunner.class)

	@SpringBootTest 
		class MovieControllerTest {
		
		@Autowired 
	  	private MovieService movieService;
		
		@MockBean 
	  	private MovieServiceImpl movieServiceImpl;

	@Test
	public void getMovieDataTest() throws Exception {
		when(movieService.getMovieData()).thenReturn((List<Movie>)Stream.of
				(new Movie(
					 1,
					 "Avatar",
					"2009",
					 "PG-13",
					 "18 Dec 2009",
					"162 min",
					 "Action,Adventure,Fantasy",
					"James Cameron",
					 "James Cameron",
					 "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang",
					 "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
					 "English, Spanish",
					 "USA, UK",
					 "Won 3 Oscars. Another 80 wins & 121 nominations.",
					 "https://m.media-amazon.com/images/M/MV5BNjA3NGExZDktNDlhZC00NjYyLTgwNmUtZWUzMDYwMTZjZWUyXkEyXkFqcGdeQXVyMTU1MDM3NDk0._V1_.jpg",
					 "83",
				     "7.9",
					 "890,617",
					 "tt0499549",
					 "movie",
					 "True",
					 "https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg"
					)).collect(Collectors.toList()));
		assertEquals(1,movieServiceImpl.getMovieData().size());
		
	}
	
	@Test
	public void addMovieTest() {
		Movie movie = new Movie( 1,
				 "Avatar",
				"2009",
				 "PG-13",
				 "18 Dec 2009",
				"162 min",
				 "Action,Adventure,Fantasy",
				"James Cameron",
				 "James Cameron",
				 "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang",
				 "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
				 "English, Spanish",
				 "USA, UK",
				 "Won 3 Oscars. Another 80 wins & 121 nominations.",
				 "https://m.media-amazon.com/images/M/MV5BNjA3NGExZDktNDlhZC00NjYyLTgwNmUtZWUzMDYwMTZjZWUyXkEyXkFqcGdeQXVyMTU1MDM3NDk0._V1_.jpg",
				 "83",
			     "7.9",
				 "890,617",
				 "tt0499549",
				 "movie",
				 "True",
				 "https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg");
		doNothing().when(movieService).addMovie(movie);
		movie.addMovie( 
				1,
				"Avatar",
				"2009",
				 "PG-13",
				 "18 Dec 2009",
				"162 min",
				 "Action,Adventure,Fantasy",
				"James Cameron",
				 "James Cameron",
				 "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang",
				 "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
				 "English, Spanish",
				 "USA, UK",
				 "Won 3 Oscars. Another 80 wins & 121 nominations.",
				 "https://m.media-amazon.com/images/M/MV5BNjA3NGExZDktNDlhZC00NjYyLTgwNmUtZWUzMDYwMTZjZWUyXkEyXkFqcGdeQXVyMTU1MDM3NDk0._V1_.jpg",
				 "83",
			     "7.9",
				 "890,617",
				 "tt0499549",
				 "movie",
				 "True",
				 "https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg");
		//assertEquals(movie, movieServiceImpl.addMovie(movie));
	}

}
