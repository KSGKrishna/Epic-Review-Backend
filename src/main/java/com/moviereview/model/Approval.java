package com.moviereview.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Approval {
	@Id
	private int userid;
	private String movies;
	private String review;
	private String status;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMovies() {
		return movies;
	}
	public void setMovies(String movies) {
		this.movies = movies;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Approval(int userid, String movies, String review, String status) {
		super();
		this.userid = userid;
		this.movies = movies;
		this.review = review;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Approval [userid=" + userid + ", movies=" + movies + ", review=" + review + ", status=" + status + "]";
	}
	
	
}
