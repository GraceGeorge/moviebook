package com.movie.theatreDTO;

import java.sql.Time;

public class ShowsDTO {
	private Integer showId;
	private Integer theatreId;
	private Integer movieId;
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

}
