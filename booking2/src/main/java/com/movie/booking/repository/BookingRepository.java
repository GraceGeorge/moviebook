package com.movie.booking.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie.booking.entity.Booking;
import com.movie.booking.entity.User;
@Repository(value="bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	public List<Booking> findByUser(User u);
	
	
	
	@Query(value="select * from Booking b where b.date>=?1 AND b.date<=?2",nativeQuery = true)
	List<Booking> bookingReport(Date start, Date end);

}
