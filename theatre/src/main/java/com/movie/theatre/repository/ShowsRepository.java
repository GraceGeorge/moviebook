package com.movie.theatre.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.movie.theatre.entity.Shows;

public interface ShowsRepository extends CrudRepository<Shows, Integer> {
	public Optional<List<Shows>> findByMovieId(Integer Id);
	public Shows deleteByMovieId(Integer Id);

}
