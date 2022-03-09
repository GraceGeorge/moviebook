package com.movie.booking.repository;



import org.springframework.data.repository.CrudRepository;

import com.movie.booking.entity.Movies;




public interface MoviesRepository extends CrudRepository<Movies, Integer>{
	
}

