package com.movie.booking.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.movie.booking.dto.BookingDTO;
import com.movie.booking.entity.Booking;

public interface BookingService {
	public void deleteBooking(Integer Id);
	public List<Booking> bookingReport(Date start, Date end);
	//public BookingDTO valueOf(Booking booking);
	public String addBooking(Booking booking);
	public Optional<Booking> findById(Integer Id);
	public List<Booking> getMyBooking(Integer userId);

}
