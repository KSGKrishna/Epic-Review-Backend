package com.moviereview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE_DETAILS")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieid;
	private String title;
	private String year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String metascore;
	private String imdb_rating;
	private String imdb_votes;
	private String imdb_id;
	private String type;
	private String response;
	private String images;
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMetascore() {
		return metascore;
	}
	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}
	public String getImdb_rating() {
		return imdb_rating;
	}
	public void setImdb_rating(String imdb_rating) {
		this.imdb_rating = imdb_rating;
	}
	public String getImdb_votes() {
		return imdb_votes;
	}
	public void setImdb_votes(String imdb_votes) {
		this.imdb_votes = imdb_votes;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int movieid, String title, String year, String rated, String released, String runtime, String genre,
			String director, String writer, String actors, String plot, String language, String country, String awards,
			String poster, String metascore, String imdb_rating, String imdb_votes, String imdb_id, String type,
			String response, String images) {
		super();
		this.movieid = movieid;
		this.title = title;
		this.year = year;
		this.rated = rated;
		this.released = released;
		this.runtime = runtime;
		this.genre = genre;
		this.director = director;
		this.writer = writer;
		this.actors = actors;
		this.plot = plot;
		this.language = language;
		this.country = country;
		this.awards = awards;
		this.poster = poster;
		this.metascore = metascore;
		this.imdb_rating = imdb_rating;
		this.imdb_votes = imdb_votes;
		this.imdb_id = imdb_id;
		this.type = type;
		this.response = response;
		this.images = images;
	}
	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdb_rating="
				+ imdb_rating + ", imdb_votes=" + imdb_votes + ", imdb_id=" + imdb_id + ", type=" + type + ", response="
				+ response + ", images=" + images + "]";
	}
	public void addMovie(int i, String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string10, String string11,
			String string12, String string13, String string14, String string15, String string16, String string17,
			String string18, String string19, String string20, String string21) {
		// TODO Auto-generated method stub
		
	}

	
		

}
