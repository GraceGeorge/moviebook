package com.movie.theatre.service;

import java.util.List;
import java.util.Optional;

import com.movie.theatre.entity.Shows;

public interface ShowsService {
	public Optional<Shows> searchShows(Integer Id);
	public Optional<List<Shows>> searchShowsByMovieId(Integer Id);
	public void deleteByMovieId(Integer Id);

}
