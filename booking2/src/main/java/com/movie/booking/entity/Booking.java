package com.movie.booking.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id")
	private Integer bookingId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="date")
	private Date date;
	@Column(name="no_seats_booked")
	private Integer seatsBooked;
	@Column(name="amount")
	private Integer totalAmount;
	@Column(name="status")
	private String status;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="show_id")
	private Shows show;
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Shows getShow() {
		return show;
	}
	public void setShow(Shows show) {
		this.show = show;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, date, seatsBooked, show, status, totalAmount, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingId, other.bookingId) && Objects.equals(date, other.date)
				&& Objects.equals(seatsBooked, other.seatsBooked) && Objects.equals(show, other.show)
				&& Objects.equals(status, other.status) && Objects.equals(totalAmount, other.totalAmount)
				&& Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + user + ", date=" + date + ", seatsBooked="
				+ seatsBooked + ", totalAmount=" + totalAmount + ", status=" + status + ", show=" + show + "]";
	}
	
	
	
	
}
