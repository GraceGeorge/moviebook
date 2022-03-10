package com.movie.theatre.api;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.movie.theatre.entity.Shows;
import com.movie.theatre.entity.Theatre;
import com.movie.theatre.service.ShowsService;
import com.movie.theatre.service.TheatreService;
import com.movie.theatreDTO.TheatreDTO;

@RestController
@RequestMapping(value="/theatre")
public class TheatreApi {
	
	@Autowired
	private TheatreService theatreService;
	
	@Autowired
	private ShowsService showsService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<TheatreDTO>> getAllMovies() {

		List<TheatreDTO> theatreList = theatreService.getAllTheatre();
		return new ResponseEntity<List<TheatreDTO>>(theatreList, HttpStatus.OK);

	}

	
	  @GetMapping(value="/{Id}") 
	  public ResponseEntity<Theatre> search(@PathVariable Integer Id){ 
		  Optional<Theatre>movie=theatreService.search(Id); 
		  
		  if(movie.isPresent()) {
	  return new ResponseEntity<Theatre>(movie.get(),HttpStatus.OK);
		  }else {
			  return new ResponseEntity<Theatre>(HttpStatus.NOT_FOUND);
		  }
	  
	  }
	 

	@PostMapping(value = "/add")
	public ResponseEntity<String> addTheatre(@RequestBody Theatre theatre) {
		theatreService.addTheatre(theatre);
		
		  String successMsg = "Theatre added"; 
		  return new ResponseEntity<String>(successMsg, HttpStatus.CREATED);
		 
	}
	
	@PostMapping(value="/update/{Id}")
	public ResponseEntity<String> updateTheatre(@PathVariable Integer Id, @RequestBody Theatre movie){
		theatreService.updateTheatre(movie, Id);
		return new ResponseEntity<String>("Theatre updated", HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/delete/{Id}")
	public ResponseEntity<String> deleteTheatre(@PathVariable Integer Id){
		theatreService.deleteTheatre(Id);
		return new ResponseEntity<String>("Theatre deleted", HttpStatus.OK);
		
	}
	
	@GetMapping(value="/shows/{Id}") 
	  public ResponseEntity<Shows> searchShows(@PathVariable Integer Id){ 
		  Optional<Shows>show=showsService.searchShows(Id); 
		  
		  if(show.isPresent()) {
	  return new ResponseEntity<Shows>(show.get(),HttpStatus.OK);
		  }else {
			  return new ResponseEntity<Shows>(HttpStatus.NOT_FOUND);
		  }
	  
	  }
	
	 @GetMapping(value="/getShowsbyTId/{Id}") 
	  public ResponseEntity<List<Shows>> findByTheatreId(@PathVariable Integer Id){
		 List<Shows> show=theatreService.findByTheatreId(Id);
		 return new ResponseEntity<List<Shows>>(show,HttpStatus.OK);
	 }
	 
	 @GetMapping(value="/getShowsbyMovieId/{Id}") 
	  public Optional<List<Shows>> findByMovieId(@PathVariable Integer Id){
		// Optional<List<Shows>> show =showsService.searchShowsByMovieId(Id);
		 return showsService.searchShowsByMovieId(Id);		 
		// return new ResponseEntity<Optional<List<Shows>>>(show,HttpStatus.OK);
	 }
	 
	 @DeleteMapping(value="/deleteShow/movieId/{Id}") 
	  public void deleteByMovieId(@PathVariable Integer Id){
		 showsService.deleteByMovieId(Id);
		 //return new ResponseEntity<String>("Show deleted",HttpStatus.OK);
	 }

}
