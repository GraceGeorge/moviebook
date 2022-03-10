package com.movie.theatre.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.theatre.entity.Theatre;

public interface TheatreRepository extends CrudRepository<Theatre, Integer> {
	public Theatre findByTheatreName(String theatreName);

}
