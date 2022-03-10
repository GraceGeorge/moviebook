package com.movie.movies.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.movie.movies.Repository.MoviesRepository;
import com.movie.movies.entity.Movies;
import com.movie.moviesDTO.MoviesDTO;
import com.movie.moviesDTO.ShowsDTO;

@Service(value="moviesService")
@Transactional
public class MoviesServiceImpl implements MoviesService {
	
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private ApiCall apiCall;
	
	
	
	
	@Override
	public List<MoviesDTO> getAllMovies(){
		
		Iterable<Movies> movies = moviesRepository.findAll();
		List<MoviesDTO> movies2 = new ArrayList<>();
		movies.forEach(movie -> {
			MoviesDTO m = new MoviesDTO();
			m.setMovieId(movie.getMovieId());
			m.setMovieName(movie.getMovieName());
			m.setDirector(movie.getDirector());
			m.setRating(movie.getRating());
			m.setGenre(movie.getGenre());
			
			
			movies2.add(m);
		});
		
		return movies2;
		}
	@Override
	public Optional<Movies> findById(Integer Id) {
		return moviesRepository.findById(Id);
	}
	@Override
	public void addMovies(Movies movies) {
		moviesRepository.save(movies);
	}
	
	@Override
	public void updateMovies(Movies movies, Integer Id) {
		moviesRepository.save(movies);
		
	}
	
	@Override
	public void deleteMovies(Integer Id) {
		moviesRepository.deleteById(Id);
	}
	
	/*
	 * public MoviesDTO getShowByMovieName(String movieName) { Optional<Movies> m =
	 * moviesRepository.findByMovieName(movieName); Movies
	 * movie=m.orElseThrow(null);
	 * 
	 * ShowsDTO shows=apiCall.getShowList(movie.getShowsId());
	 * 
	 * }
	 */
	
	public MoviesDTO showsByMovieName(String movieName) {
		System.out.println("2####");
		// getting student from table by passing id
		Movies m = moviesRepository.findByMovieName(movieName).orElse(null);
		
		//getting course from course microservice by call API
		//ShowsDTO show = apiCall.getShowList(m.getList<ShowsId>());
		
		  List<ShowsDTO> show = apiCall.getShowList(m.getMovieId());
		  System.out.println("4#######");
		  
		  MoviesDTO sd = new MoviesDTO(); 
		  BeanUtils.copyProperties(show, sd);
		  sd.setShow(show); 
		  return sd;
		 
		
	}
	public MoviesDTO correspondingShows(Integer movieId) {
		Movies m=findByMovieId(movieId);
		MoviesDTO m1=valueof(m);
		ShowsDTO[]shows=new RestTemplate().getForObject("http://localhost:8084/theatre/getShowsbyMovieId/" + movieId, ShowsDTO[].class);
		//ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("localhost:8083/connectors/", String[].class);
		//List<String> object = Arrays.asList(responseEntity.getBody());
		List<ShowsDTO> show=Arrays.asList(shows);
		m1.setShow(show);
		return m1;
		/*
		 * for(ShowsDTO s:show) { m1.setShow(s);
		 * 
		 * }
		 */
	}
	
	public List<ShowsDTO> listShowsOfMovie(Integer movieId) {
		ShowsDTO[]shows=new RestTemplate().getForObject("http://localhost:8084/theatre/getShowsbyMovieId/" + movieId, ShowsDTO[].class);
		
		List<ShowsDTO> show=Arrays.asList(shows);
		return show;
		
	}
	
	public Movies findByMovieId(Integer Id){
		Optional<Movies> s=moviesRepository.findByMovieId(Id);
		Movies movie = s.orElse(null);
		return movie;
	}	
	public MoviesDTO valueof(Movies movie) {
		MoviesDTO movieDTO=new MoviesDTO();
		movieDTO.setMovieId(movie.getMovieId());
		movieDTO.setMovieName(movie.getMovieName());
		movieDTO.setDirector(movie.getDirector());
		movieDTO.setGenre(movie.getGenre());
		movieDTO.setRating(movie.getRating());
	
		//show.setShowId(movie.getShowId());
		
		
		return movieDTO;
	}
	
}

	
		
		

		
	

