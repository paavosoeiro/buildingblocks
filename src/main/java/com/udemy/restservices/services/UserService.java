package com.udemy.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.restservices.entities.User;
import com.udemy.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public User createUser(User user) {
		return this.userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) {
		return this.userRepository.findById(id);
	}
	
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return this.userRepository.save(user);
	}
	
	public void deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	public User getUserByUserName(String userName) {
		return this.userRepository.findByUserName(userName);
	}
}
