package com.udemy.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.udemy.restservices.entities.User;
import com.udemy.restservices.exceptions.UserExistsException;
import com.udemy.restservices.exceptions.UserNotFoundException;
import com.udemy.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public User createUser(User user) throws UserExistsException {
		User existingUser = this.userRepository.findByUserName(user.getUserName());
		
		if (existingUser != null) {
			throw new UserExistsException("User already exists");
		}
		
		return this.userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = this.userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		
		return user;
	}
	
	public User updateUserById(Long id, User user) throws UserNotFoundException {
		Optional<User> userOptional = this.userRepository.findById(id);
		
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found, provide the correct user id");
		}
		
		user.setId(id);
		return this.userRepository.save(user);
	}
	
	public void deleteUserById(Long id) {
		Optional<User> userOptional = this.userRepository.findById(id);
		
		if (!userOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not Found, provide the correct user id");
		}
		
		userRepository.deleteById(id);
	}
	
	public User getUserByUserName(String userName) {
		return this.userRepository.findByUserName(userName);
	}
}
