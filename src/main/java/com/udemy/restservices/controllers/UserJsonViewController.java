package com.udemy.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.udemy.restservices.entities.User;
import com.udemy.restservices.entities.Views;
import com.udemy.restservices.exceptions.UserNotFoundException;
import com.udemy.restservices.services.UserService;

@RestController
@RequestMapping("/jsonview/users")
@Validated
public class UserJsonViewController {

	@Autowired
	private UserService userService;

	@GetMapping("/external/{id}")
	@JsonView(Views.External.class)
	public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			return this.userService.getUserById(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/internal/{id}")
	@JsonView(Views.Internal.class)
	public Optional<User> getUserById2(@PathVariable("id") @Min(1) Long id) {
		try {
			return this.userService.getUserById(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
