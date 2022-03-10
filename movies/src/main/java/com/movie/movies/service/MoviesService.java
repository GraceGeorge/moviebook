package com.movie.movies.service;

import java.util.List;
import java.util.Optional;

import com.movie.movies.entity.Movies;
import com.movie.moviesDTO.MoviesDTO;
import com.movie.moviesDTO.ShowsDTO;

public interface MoviesService {
	
	public List<MoviesDTO> getAllMovies();
	public Optional<Movies> findById(Integer Id);
	public void addMovies(Movies movies);
	public void updateMovies(Movies movies, Integer Id);
	public void deleteMovies(Integer Id);
	public MoviesDTO showsByMovieName(String movieName);
	public Movies findByMovieId(Integer Id);
	public MoviesDTO correspondingShows(Integer movieId);
	public MoviesDTO valueof(Movies movie);
	public List<ShowsDTO> listShowsOfMovie(Integer movieId);

}
