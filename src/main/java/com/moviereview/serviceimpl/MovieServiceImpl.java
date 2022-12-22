package com.moviereview.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviereview.DBUtil.DBUtil;
import com.moviereview.model.Movie;
import com.moviereview.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService {

	
	@Autowired
	static List<Movie> movielist=new ArrayList<Movie>();
	 
	Connection connection;
	
	public MovieServiceImpl() throws SQLException 
	{
		connection = DBUtil.getConnection();
	}

	@Override
	public List<Movie> getMovieData() {
		 List<Movie> movielist=new ArrayList<Movie>();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM epicreviews.movie_details; ");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Movie mve=new Movie();
				mve.setMovieid(rs.getInt(1));			
				mve.setTitle(rs.getString(2));
				mve.setYear(rs.getString(3));
				mve.setRated(rs.getString(4));
				mve.setReleased(rs.getString(5));
				mve.setRuntime(rs.getString(6));
				mve.setGenre(rs.getString(7));
				mve.setDirector(rs.getString(8));
				mve.setWriter(rs.getString(9));
				mve.setActors(rs.getString(10));
				mve.setPlot(rs.getString(11));
				mve.setLanguage(rs.getString(12));
				mve.setCountry(rs.getString(13));
				mve.setAwards(rs.getString(14));
				mve.setPoster(rs.getString(15));
				mve.setMetascore(rs.getString(16));
				mve.setImdb_rating(rs.getString(17));
				mve.setImdb_votes(rs.getString(18));
				mve.setImdb_id(rs.getString(19));
				mve.setType(rs.getString(20));
				mve.setResponse(rs.getString(21));
				mve.setImages(rs.getString(22));
			
				
				movielist.add(mve);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return movielist;
	}

	@Override
	public void addMovie(Movie mve) {
		int movieid=mve.getMovieid();
		String title=mve.getTitle();
		String year=mve.getYear();
		String rated=mve.getRated();
		String released=mve.getReleased();
		String runtime=mve.getRuntime();
		String genre=mve.getGenre();
		String director=mve.getDirector();
		String writer=mve.getWriter();
		String actors=mve.getActors();
		String plot=mve.getPlot();
		String language=mve.getLanguage();
		String country=mve.getCountry();
		String awards=mve.getAwards();
		String poster=mve.getPoster();
		String metascore=mve.getMetascore();
		String imdb_rating=mve.getImdb_rating();
		String imdb_votes=mve.getImdb_votes();
		String imdb_id=mve.getImdb_id();
		String type=mve.getType();
		String response=mve.getResponse();
		String images=mve.getImages();
		
		
		
		String insertQuery="INSERT INTO movie_details VALUES('"+movieid+"','"+title+"','"+year+"','"+rated+"','"+released+"','"+runtime+"','"+genre+"','"+
													      director+"','"+writer+"','"+actors+"','"+plot+"','"+language+"','"+country+"','"+awards+"','"+poster+"','"+metascore+"','"+
													      imdb_rating+"','"+imdb_votes+"','"+imdb_id+"','"+type+"','"+response+"','"+images+"');";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Movie Added");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteMovie(String Title) {
		String deleteQuery="DELETE FROM movie_details WHERE movieid='"+Integer.parseInt(Title)+"'";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Movie deleted");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		

	@Override
	public void updateMovie(Movie mve) {
		int movieid=mve.getMovieid();
		String title=mve.getTitle();
		String year=mve.getYear();
		String rated=mve.getRated();
		String released=mve.getReleased();
		String runtime=mve.getRuntime();
		String genre=mve.getGenre();
		String director=mve.getDirector();
		String writer=mve.getWriter();
		String actors=mve.getActors();
		String plot=mve.getPlot();
		String language=mve.getLanguage();
		String country=mve.getCountry();
		String awards=mve.getAwards();
		String poster=mve.getPoster();
		String metascore=mve.getMetascore();
		String imdb_rating=mve.getImdb_rating();
		String imdb_votes=mve.getImdb_votes();
		String imdb_id=mve.getImdb_id();
		String type=mve.getType();
		String response=mve.getResponse();
		String images=mve.getImages();
	
		
		String updateQuery="UPDATE movie_details SET movieid='"+movieid+"','"+title+"','"+year+"','"+rated+"','"+released+"','"+runtime+"','"+genre+"','"+
																      director+"','"+writer+"','"+actors+"','"+plot+"','"+language+"','"+country+"','"+awards+"','"+poster+"','"+metascore+"','"+
																      imdb_rating+"','"+imdb_votes+"','"+imdb_id+"','"+type+"','"+response+"','"+images+"';";
				
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("UPDATED SUCCESSFULLY");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	//get movie by id

	@Override
	public List<Movie> getMovieData(Integer movieid) {
		
		 List<Movie> movielist=new ArrayList<Movie>();
			
			try {
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MOVIE_DETAILS WHERE movieid='"+movieid+"'");
				ResultSet rs = stmt.executeQuery();
				
				
				while(rs.next()) {
					Movie mve=new Movie();
					mve.setMovieid(rs.getInt(1));
					mve.setTitle(rs.getString(2));
					mve.setYear(rs.getString(3));
					mve.setRated(rs.getString(4));
					mve.setReleased(rs.getString(5));
					mve.setRuntime(rs.getString(6));
					mve.setGenre(rs.getString(7));
					mve.setDirector(rs.getString(8));
					mve.setWriter(rs.getString(9));
					mve.setActors(rs.getString(10));
					mve.setPlot(rs.getString(11));
					mve.setLanguage(rs.getString(12));
					mve.setCountry(rs.getString(13));
					mve.setAwards(rs.getString(14));
					mve.setPoster(rs.getString(15));
					mve.setMetascore(rs.getString(16));
					mve.setImdb_rating(rs.getString(17));
					mve.setImdb_votes(rs.getString(18));
					mve.setImdb_id(rs.getString(19));
					mve.setType(rs.getString(20));
					mve.setResponse(rs.getString(21));
					mve.setImages(rs.getString(22));
			
					movielist.add(mve);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return movielist;
	}


	



	
}
