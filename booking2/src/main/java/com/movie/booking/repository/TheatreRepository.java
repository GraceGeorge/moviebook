package com.movie.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.entity.Theatre;

public interface TheatreRepository extends CrudRepository<Theatre, Integer> {


}