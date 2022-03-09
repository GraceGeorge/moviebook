package com.movie.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.movie.booking.entity.Shows;

public interface ShowsRepository extends JpaRepository<Shows, Integer>{

}
