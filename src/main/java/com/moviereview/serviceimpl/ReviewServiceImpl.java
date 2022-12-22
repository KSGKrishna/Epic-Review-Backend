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
import com.moviereview.model.Review;
import com.moviereview.service.ReviewService;
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	static List<Review> reviewlist=new ArrayList<Review>();
	 
	Connection connection;
	
	public ReviewServiceImpl() throws SQLException 
	{
		connection = DBUtil.getConnection();
	}

	@Override
	public List<Review> getReviewData() {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM REVIEW");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Review rvw =new Review();
				rvw.setRvwid(rs.getInt(1));
				rvw.setMovies(rs.getString(2));
				rvw.setReviews(rs.getString(3));
				rvw.setRating(rs.getString(4));
				rvw.setUser(rs.getString(5));
				
				
				reviewlist.add(rvw);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reviewlist;
	}

	@Override
	public void addReview(Review rvw) {
		Integer rvwid=rvw.getRvwid();
		String movies=rvw.getMovies();
		String reviews=rvw.getReviews();
		String rating=rvw.getRating();
		String user=rvw.getUser();
		

		
		String insertQuery="INSERT INTO review VALUES('"+rvwid+"','"+movies+"','"+reviews+"','"+rating+"','"+user+"')";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Review Added");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
  @Override
	public void deleteReview(int rvwid) {
		String deleteQuery="DELETE FROM review WHERE rvwid='"+rvwid+"'";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Review deleted");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}

	@Override
	public List<Review> getReviewData(Integer rvwid) {
		List<Review> reviewlist=new ArrayList<Review>();
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM REVIEW WHERE rvwid='"+rvwid+"'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Review rvw=new Review();
				rvw.setRvwid(rs.getInt(1));			
				rvw.setMovies(rs.getString(2));
				rvw.setReviews(rs.getString(3));
				rvw.setRating(rs.getString(4));
				rvw.setUser(rs.getString(5));
				
				reviewlist.add(rvw);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reviewlist;
	}


}

//package com.moviereview.serviceimpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.moviereview.model.Review;
//import com.moviereview.service.ReviewService;
//
//
//@Service
//public class ReviewServiceImpl {
//	
//	@Autowired
//	private ReviewService reviewService;
//	
//	public Review addReview(Review review) {
//		return reviewService.save(review);
//	}
//	
//	public List<Review> getReviews(){
//		return (List<Review>) reviewService.findAll();		 
//	}
//	
//	public void deleteReview(Integer r_no) {
//		reviewService.deleteById(r_no);
//	}
//	
//	public Review updateReview(Review review) {
//		Integer r_no = review.getR_no();
//		Review rvw = reviewService.findById(r_no).get();
//		rvw.setMoviename(review.getMoviename());
//		rvw.setReview(review.getReview());
//		rvw.setRating(review.getRating());
//		return reviewService.save(rvw);
//	}
//	
//}
