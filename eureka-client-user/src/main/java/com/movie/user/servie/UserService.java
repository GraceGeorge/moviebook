package com.movie.user.servie;

import java.util.List;

import com.movie.user.dto.UserDTO;
import com.movie.user.entity.User;

public interface UserService{
	/*
	 * public List<UserDTO> getAllUserDetails();
	 * 
	 * public void Register(UserDTO user) throws Exception;
	 */
	public String addUser(User user);
	public User login(String userName, String password);

}
