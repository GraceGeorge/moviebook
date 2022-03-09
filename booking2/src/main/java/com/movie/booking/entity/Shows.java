package com.movie.booking.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shows")
public class Shows {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="show_id")
	private Integer showId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="theatre_id")
	private Theatre theatre;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movie_id")
	private Movies movie;
	
	@Column(name="show_time")
	private Date showTime;
	private Integer seats;
	
	
    public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovieId(Movies movie) {
		this.movie = movie;
	}

	public Date getShowTime() {
		return showTime;
	}

	public void setShowTime(Date showTime) {
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
		return Objects.hash(movie, seats, showId, showTime, theatre);
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
				&& Objects.equals(theatre, other.theatre);
	}

	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", theatreId=" + theatre + ", movieId=" + movie + ", showTime="
				+ showTime + ", seats=" + seats + "]";
	}

	

	

	

	
	
	
	
	

}
