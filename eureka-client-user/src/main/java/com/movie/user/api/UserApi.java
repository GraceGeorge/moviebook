package com.movie.user.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.user.dto.UserDTO;
import com.movie.user.entity.User;
import com.movie.user.servie.UserService;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value="/u")
public class UserApi {
	
	@Autowired
	private UserService userService;
	
	/*
	 * @GetMapping(value="/users") public List<UserDTO> getAllUserDetails() { return
	 * userService.getAllUserDetails();
	 * }
	 */
	
	@GetMapping(value="/test")
	public String test() {
		System.out.println("test");
		return "hello";
	}
	
	
	@PostMapping(value="/r")
	public ResponseEntity<String> addUser(@RequestBody User user){
		System.out.println("1");
		String msg = userService.addUser(user);
		System.out.println("2");
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping(value="/login/{userName}/{passWord}")
	public ResponseEntity<User> login(@PathVariable String userName, @PathVariable String passWord){
		System.out.println("Username:" +userName);
		System.out.println("Password:" +passWord);
		User response=userService.login(userName, passWord);
		if(response ==null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<User>(response, HttpStatus.OK);
		
		}
	
}
