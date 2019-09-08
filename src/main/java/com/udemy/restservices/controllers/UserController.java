package com.udemy.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.restservices.entities.User;
import com.udemy.restservices.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return this.userService.getUserById(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		return this.userService.updateUserById(id, user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		this.userService.deleteUserById(id);
	}
	
	@GetMapping("/users/byusername/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) {
		return this.getUserByUserName(userName);
	}
}
