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
import com.moviereview.model.Movies;
import com.moviereview.service.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService {
	@Autowired
	static List<Movies> movieslist=new ArrayList<Movies>();
	 
	Connection connection;
	
	public MoviesServiceImpl() throws SQLException 
	{
		connection = DBUtil.getConnection();
	}


	@Override
	public List<Movies> getMoviesData() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM epicreviews.movies_list ");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Movies mv=new Movies();
				mv.setM_id(rs.getInt(1));			
				mv.setMovies(rs.getString(2));
				mv.setGenre(rs.getString(3));
			
				movieslist.add(mv);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		return movieslist;
	}


	@Override
	public List<Movies> getMoviesData(String genre) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM epicreviews.movies_list WHERE genre='"+genre+"'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Movies mv=new Movies();
				mv.setM_id(rs.getInt(1));			
				mv.setMovies(rs.getString(2));
				mv.setGenre(rs.getString(3));
		
		
				movieslist.add(mv);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return movieslist;
	}
}