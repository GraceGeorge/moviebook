package com.movie.moviesDTO;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.movie.movies.entity.Movies;


public class MoviesDTO {
	
	private Integer movieId;
	private String movieName;
	private String director;
	private Double rating;
	private String genre;
	private List<ShowsDTO> show = new ArrayList<ShowsDTO>();
	
	public List<ShowsDTO> getShow() {
		return show;
	}
	public void setShow(List<ShowsDTO> show) {
		this.show = show;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public int hashCode() {

		return 31;
	}

	
	
	@Override
	public String toString() {
		return "MoviesDTO [movieId=" + movieId + ", movieName=" + movieName + ", director=" + director + ", rating=" + rating + "genre" +genre + "]";
	}
	
	
	
}
