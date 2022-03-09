package com.movie.booking.dto;

import java.time.LocalDateTime;
import java.util.Objects;


public class BookingDTO {
	
	private Integer bookingId;
	private Integer userId;
	private Integer showId;
	private LocalDateTime date;
	private Integer seatsBooked;
	private Integer totalAmount;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Integer getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", userId=" + userId + ", showId=" + showId + ", date=" + date
				+ ", seatsBooked=" + seatsBooked + ", totalAmount=" + totalAmount +",status" + status+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, date, seatsBooked, showId, totalAmount, userId, status);
	}
	
	
	

}
