package com.movie.booking.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.booking.dto.BookingDTO;
import com.movie.booking.entity.Booking;
import com.movie.booking.entity.Shows;
import com.movie.booking.entity.Theatre;
import com.movie.booking.entity.User;
import com.movie.booking.repository.BookingRepository;
import com.movie.booking.repository.MoviesRepository;
import com.movie.booking.repository.ShowsRepository;
import com.movie.booking.repository.TheatreRepository;

@Service
public class BookingSeviceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ShowsRepository showsRepository;
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Autowired
	private MoviesRepository movieRepository;
	
	@Override
	public void deleteBooking(Integer Id) {
		Optional<Booking> b=bookingRepository.findById(Id);
		Booking b1=b.orElse(null);
		Shows s=b1.getShow();
		Integer currentSeats = s.getSeats();
		s.setSeats(currentSeats+b1.getSeatsBooked());
		showsRepository.save(s);
		b1.setShow(null);
		b1.setShow(null);
		bookingRepository.deleteById(Id);
	}
	@Override
	public List<Booking> bookingReport(Date start, Date end) {
		System.out.println("b2####");
		return bookingRepository.bookingReport(start, end);
	}
	@Override
	public String addBooking(Booking booking) {
		//booking.setDate(java.time.LocalDateTime.now());
		
		Integer n=booking.getSeatsBooked();
		Integer theatreId = booking.getShow().getTheatre().getTheatreId();
		Optional<Theatre> t = theatreRepository.findById(theatreId);
		Theatre theatre=t.orElse(null);
		Integer rate=theatre.getRate();
		Integer total=n*rate;
		booking.setTotalAmount(total);
		Integer showId=booking.getShow().getShowId();
		Optional<Shows> s1=showsRepository.findById(showId);
		Shows s=s1.orElse(null);
		
		Integer availSeats=s.getSeats();
		//int availSeats=availSeats1.intValue();
		 /* 
		 * 
		 * Shows show=booking.getShow(); Integer availSeats=show.getSeats();
		 * System.out.println("2#######");
		 */
		Optional<User> u=userRepository.findById(booking.getuser().getUserId());
		User user=u.orElse(null);
		booking.setUserId(user);
		Optional<Shows> s2=showsRepository.findById(booking.getShow().getShowId());
		Shows shows=s2.orElse(null);
		booking.setShow(show);
		if(booking.getSeatsBooked()>availSeats) 
			return "Only "+availSeats+" remaining";
		
		else {
		bookingRepository.save(booking);
		Integer remSeats=availSeats-n;
		s.setSeats(remSeats);
		//s.setMovieId(s.getMovieId());
		showsRepository.saveAndFlush(s);
		
		return "Booking success";
		}
		
		
		/*
		 * Optional<Shows> s1=showsRepository.findById(showId); Shows s=s1.orElse(null);
		 * s.getSeats();
		 */
		
		
		/*
		 * Shows s=new Shows(); s.setShowId(showId);
		 * s.setSeats(s.getSeats()-booking.getSeatsBooked());
		 */
	}
	@Override
	public Optional<Booking> findById(Integer Id) {
		System.out.println("3#######");
		return bookingRepository.findById(Id);
		
		
	}
	
	@Override
	public List<Booking> getMyBooking(Integer userId) {
		System.out.println("3######");
		System.out.println("byuserid");
		Optional<User> u1=userRepository.findById(userId);
		User u=u1.orElse(null);
		return bookingRepository.findByUser(u);
	}
	
	
	}
	
	


