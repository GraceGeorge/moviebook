package com.movie.theatre.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.movie.theatreDTO.ShowsDTO;

@Entity
public class Shows {
	@Id
	private Integer showId;
	@Column(name="theatre_id")
	private Integer theatreId;
	@Column(name="movie_id")
	private Integer movieId;
	@Column(name="show_time")
	private Time showTime;
	private Integer seats;
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public Integer getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Time getShowTime() {
		return showTime;
	}
	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	
	@Override
	public int hashCode() {

		return 31;
	}

	
	
	@Override
	public String toString() {
		return "ShowsDTO [showId=" + showId + ", theatreId" + theatreId + ", movieId=" + movieId + ", showTime=" + showTime + "seats" +seats + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		ShowsDTO other = (ShowsDTO) obj;
		if (this.getShowId() == null) {
			if (other.getShowId() != null)
				return false;
		} else if (!this.getShowId().equals(other.getShowId()))
			return false;
		return true;
	}

}
