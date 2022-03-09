package com.movie.booking.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.booking.entity.Booking;
import com.movie.booking.service.BookingService;
import com.movie.booking.service.UserService;


@RestController
@RequestMapping(value="/booking")
public class BookingApi {
	@Autowired
	private BookingService bookingService;
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/{Id}") 
	  public ResponseEntity<Booking> findById(@PathVariable Integer Id){ 
		System.out.println("1#####");
		  Optional<Booking>movie=bookingService.findById(Id); 
		  
		  if(movie.isPresent()) {
	  return new ResponseEntity<Booking>(movie.get(),HttpStatus.OK);
		  }else {
			  return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
		  }
	  
	  }
	@PostMapping(value = "/add")
	public ResponseEntity<String> addMovies(@RequestBody Booking booking) {
		System.out.println("H1111111111");
		String successMsg=bookingService.addBooking(booking);
		Integer num=booking.getSeatsBooked();
		
		  
		  return new ResponseEntity<String>(successMsg, HttpStatus.CREATED);
		 
	}
	@DeleteMapping(value="/deleteBooking/{Id}")
	public ResponseEntity<String> deleteBooking(@PathVariable Integer Id){
		bookingService.deleteBooking(Id);
		return new ResponseEntity<String>("Booking deleted", HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteUser/{Id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer Id){
		userService.deleteUser(Id);
		return new ResponseEntity<String>("User and corresponding booking deleted", HttpStatus.OK);
	}
	
	@GetMapping(value="/bookingReport/{start}/{end}")
	public ResponseEntity<List<Booking>> bookingReport(@PathVariable String start, @PathVariable String end) throws ParseException{
		//String date1 = DateFormat.getInstance().format(start);
		//String date2 = DateFormat.getInstance().format(end);
		
		
		DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date1 = (Date)formatter1.parse(start);
		DateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date2 = (Date)formatter2.parse(end);
		/*
		 * SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); Date
		 * date1=formatter1.parse(start); SimpleDateFormat formatter2=new
		 * SimpleDateFormat("dd/MM/yyyy"); Date date2=formatter2.parse(end);
		 */
		List<Booking>bookings=bookingService.bookingReport(date1, date2);
		System.out.println("b1####");
		System.out.println("hi");
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}
	

}
