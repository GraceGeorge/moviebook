package com.movie.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.moviesDTO.MoviesDTO;
import com.movie.moviesDTO.ShowsDTO;

@Service
public class ApiCall {
		
		@Autowired 
		RestTemplate restTemplate;

		private static final String theatreServiceBaseUrl="http://theatre-service";
		
		public List<ShowsDTO> getShowList(int movieId) {
			/*
			 * List<ShowsDTO> show=restTemplate.getForObject( theatreServiceBaseUrl +
			 * "theatre/shows/{id}", ShowsDTO.class, movieId);
			 */
			System.out.println("3####");
			List<ShowsDTO> show = (List<ShowsDTO>) restTemplate.getForObject
			(theatreServiceBaseUrl + "/theatre/id?id={movieId}", ShowsDTO.class, movieId);
			
			return show;
		}
	}



