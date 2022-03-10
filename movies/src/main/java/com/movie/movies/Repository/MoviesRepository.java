package com.movie.movies.Repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.movie.movies.entity.Movies;



public interface MoviesRepository extends CrudRepository<Movies, Integer>{
	
	public Optional<Movies> findByMovieName(String movieName);
	public Optional<Movies> findByMovieId(Integer id);

	
}
