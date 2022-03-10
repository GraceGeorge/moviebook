package com.movie.theatre.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.theatre.entity.Shows;
import com.movie.theatre.entity.Theatre;
import com.movie.theatre.repository.TheatreRepository;
import com.movie.theatreDTO.TheatreDTO;

@Service
public class TheatreServieImpl implements TheatreService {
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	
	
	@Override
	public List<TheatreDTO> getAllTheatre(){
		
		Iterable<Theatre> theatre = theatreRepository.findAll();
		List<TheatreDTO> theatre2 = new ArrayList<>();
		theatre.forEach(movie -> {
			TheatreDTO m = new TheatreDTO();
			m.setTheatreId(movie.getTheatreId());
			m.setTheatreName(movie.getTheatreName());
			m.setTheatreLoc(movie.getTheatreLoc());
			m.setCapacity(movie.getCapacity());
			m.setRate(movie.getRate());
			
			
			theatre2.add(m);
		});
		return theatre2;
	}
	
	@Override
	public Optional<Theatre> search(Integer Id) {
		return theatreRepository.findById(Id);
	}
	@Override
	public void addTheatre(Theatre theatre) {
		theatreRepository.save(theatre);
	}
	
	@Override
	public void updateTheatre(Theatre theatre, Integer Id) {
		theatreRepository.save(theatre);
		
	}
	
	@Override
	public void deleteTheatre(Integer Id) {
		theatreRepository.deleteById(Id);
	}
	
	
	
	public List<Shows> findByTheatreId(Integer Id){
		Optional<Theatre> s=theatreRepository.findById(Id);
		Theatre theatre = s.orElse(null);
		List<Shows>shows=theatre.getShows();
		return shows;
		
		
	}

}
