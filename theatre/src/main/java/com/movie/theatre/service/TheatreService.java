package com.movie.theatre.service;

import java.util.List;
import java.util.Optional;

import com.movie.theatre.entity.Shows;
import com.movie.theatre.entity.Theatre;
import com.movie.theatreDTO.TheatreDTO;

public interface TheatreService {
	
	public List<TheatreDTO> getAllTheatre();
	public Optional<Theatre> search(Integer Id);
	public void addTheatre(Theatre theatre);
	public void updateTheatre(Theatre theatre, Integer Id);
	public void deleteTheatre(Integer Id);
	public List<Shows> findByTheatreId(Integer Id);
}
