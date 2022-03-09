package com.movie.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
