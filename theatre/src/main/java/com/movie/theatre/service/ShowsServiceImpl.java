package com.movie.theatre.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.theatre.entity.Shows;
import com.movie.theatre.repository.ShowsRepository;
@Service
@Transactional
public class ShowsServiceImpl implements ShowsService {
	
	@Autowired
	private ShowsRepository showsRepository;
	
	public static <Shows> List<Shows> toList(Optional<Shows> opt) {
	    return opt
	            .map(Collections::singletonList)
	            .orElseGet(Collections::emptyList);
	}
	
	@Override
	public Optional<Shows> searchShows(Integer Id) {
		return showsRepository.findById(Id);
	}
	
	
	@Override
	public Optional<List<Shows>> searchShowsByMovieId(Integer Id) {
		return showsRepository.findByMovieId(Id);
		
	}
	
	@Override
	public void deleteByMovieId(Integer Id) {
		showsRepository.deleteByMovieId(Id);
	}

}
