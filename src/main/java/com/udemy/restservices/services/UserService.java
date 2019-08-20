package com.udemy.restservices.services;

import java.util.List;

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
}
