package com.moviereview.model;

public class Movies {
	int m_id;
	String movies;
	String genre;
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getMovies() {
		return movies;
	}
	public void setMovies(String movies) {
		this.movies = movies;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movies(int m_id, String movies, String genre) {
		super();
		this.m_id = m_id;
		this.movies = movies;
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Movies [m_id=" + m_id + ", movies=" + movies + ", genre=" + genre + "]";
	}
	

}
