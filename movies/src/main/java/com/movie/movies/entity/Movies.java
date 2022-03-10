package com.movie.movies.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.movie.moviesDTO.MoviesDTO;

@Entity
@Table(name="movies")
public class Movies {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movie_id")
	private Integer movieId;
	@Column(name="movie_name")
	private String movieName;
	private String director;
	private Double rating;
	private String genre;
	/*
	 * //@Column(name="show_id") //private List<Integer> showId; //public
	 * List<Integer> getShowId() { return showId; } public void
	 * setShowId(List<Integer> showId) { this.showId = showId;
	 */
	//}
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
		return Objects.hash(director, genre, movieId, movieName, rating);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		return Objects.equals(director, other.director) && Objects.equals(genre, other.genre)
				&& Objects.equals(movieId, other.movieId) && Objects.equals(movieName, other.movieName)
				&& Objects.equals(rating, other.rating);
	}
	
	@Override
	public String toString() {
		return "MoviesDTO [movieId=" + movieId + ", movieName=" + movieName + ", director=" + director + ", rating=" + rating + "genre" +genre + "]";
	}
	public Object getShowsId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
