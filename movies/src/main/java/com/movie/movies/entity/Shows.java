package com.movie.movies.entity;

import java.sql.Time;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="shows")
public class Shows {
	@Id
	private Integer showId;
	@Column(name="theatre_id")
	private Integer theatreId;
	@Column(name="show_time")
	private Time showTime;
	private Integer seats;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="movie_id")
	private Movies movie;
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
	public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movie, seats, showId, showTime, theatreId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shows other = (Shows) obj;
		return Objects.equals(movie, other.movie) && Objects.equals(seats, other.seats)
				&& Objects.equals(showId, other.showId) && Objects.equals(showTime, other.showTime)
				&& Objects.equals(theatreId, other.theatreId);
	}
	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", theatreId=" + theatreId + ", showTime=" + showTime + ", seats=" + seats
				+ ", movie=" + movie + "]";
	}
	
	

}
