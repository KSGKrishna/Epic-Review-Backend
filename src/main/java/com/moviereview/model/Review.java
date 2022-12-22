package com.moviereview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
//	
//	@GeneratedValue(strategy = GenerationType.AUTO)
	int rvwid;
	String movies;
	String reviews;
	String rating;
	String user;
	
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getRvwid() {
		return rvwid;
	}
	public void setRvwid(int rvwid) {
		this.rvwid = rvwid;
	}
	public String getMovies() {
		return movies;
	}
	public void setMovies(String movies) {
		this.movies = movies;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int rvwid,String movies, String reviews,String rating,String user) {
		super();
		this.rvwid=rvwid;
		this.movies = movies;
		this.reviews = reviews;
		this.rating=rating;
		this.user=user;
	}
		@Override
	public String toString() {
		return "Review [ rvwid="+rvwid+",movies=" + movies + ", reviews=" + reviews + "]";
	}
		public void addReview(int i, String string, String string2, String string3, String string4) {
			// TODO Auto-generated method stub
			
		}

}

//package com.moviereview.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Review{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer r_no;
//	private String moviename;
//	private String review;
//	private Double rating;
//	public Integer getR_no() {
//		return r_no;
//	}
//	public void setR_no(Integer r_no) {
//		this.r_no = r_no;
//	}
//	public String getMoviename() {
//		return moviename;
//	}
//	public void setMoviename(String moviename) {
//		this.moviename = moviename;
//	}
//	public String getReview() {
//		return review;
//	}
//	public void setReview(String review) {
//		this.review = review;
//	}
//	public Double getRating() {
//		return rating;
//	}
//	public void setRating(Double rating) {
//		this.rating = rating;
//	}
//	
//	
//	
//	
//	
//}
	
	

