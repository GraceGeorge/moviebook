package com.movie.movies.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movies.entity.Movies;
import com.movie.movies.service.MoviesService;
import com.movie.moviesDTO.MoviesDTO;
import com.movie.moviesDTO.ShowsDTO;

@RestController
@RequestMapping(value = "/movies")
public class MoviesApi {

	@Autowired
	private MoviesService moviesService;

	@GetMapping(value="/test")
	public ResponseEntity<String>test(){
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<MoviesDTO>> getAllMovies() {

		List<MoviesDTO> movieList = moviesService.getAllMovies();
		return new ResponseEntity<>(movieList, HttpStatus.OK);

	}
	  @GetMapping(value="/{Id}") 
	  public ResponseEntity<Movies> findById(@PathVariable Integer Id){ 
		  Optional<Movies>movie=moviesService.findById(Id); 
		  
		  if(movie.isPresent()) {
	  return new ResponseEntity<Movies>(movie.get(),HttpStatus.OK);
		  }else {
			  return new ResponseEntity<Movies>(HttpStatus.NOT_FOUND);
		  }
	  
	  }
	 

	@PostMapping(value = "/add")
	public ResponseEntity<String> addMovies(@RequestBody Movies movies) {
		moviesService.addMovies(movies);
		
		  String successMsg = "Movie added"; 
		  return new ResponseEntity<String>(successMsg, HttpStatus.CREATED);
		 
	}
	
	@PostMapping(value="/update/{Id}")
	public ResponseEntity<String> updateMovies(@PathVariable Integer Id, @RequestBody Movies movie){
		moviesService.updateMovies(movie, Id);
		return new ResponseEntity<String>("Movie added", HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/delete/{Id}")
	public ResponseEntity<String> deleteMovies(@PathVariable Integer Id){
		
		try {
		moviesService.deleteMovies(Id);
		return new ResponseEntity<String>("Movie deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Movie cannot be deleted", HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/name/{movieName}")
	public MoviesDTO showsByMovieName(@PathVariable String movieName) {
		System.out.println("1########");
		return moviesService.showsByMovieName(movieName);
	}
	@GetMapping(value = "/id/{id}")//displays movie & its shows
	public MoviesDTO getShowsWithMovieId(@PathVariable Integer id) {
		return moviesService.correspondingShows(id);
		
	}
	
	@GetMapping(value = "/list/{id}")
	public List<ShowsDTO> getShowsListWithMovieId(@PathVariable Integer id) {
		return moviesService.listShowsOfMovie(id);
		
	}
	
}
