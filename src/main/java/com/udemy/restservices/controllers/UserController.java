package com.udemy.restservices.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.udemy.restservices.entities.User;
import com.udemy.restservices.exceptions.UserExistsException;
import com.udemy.restservices.exceptions.UserNameNotFoundException;
import com.udemy.restservices.exceptions.UserNotFoundException;
import com.udemy.restservices.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "User Management RESTful Services", value = "UserController")
@RestController
@Validated
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Retrieve list of users")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@ApiOperation(value = "Create a new user")
	@PostMapping
	public ResponseEntity<Void> createUser(
			@ApiParam(value = "User information for a new user to be created.") @Valid @RequestBody User user,
			UriComponentsBuilder builder) {
		try {
			this.userService.createUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getUserId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> optionalUser = this.userService.getUserById(id);
			return optionalUser.get();
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			return this.userService.updateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		this.userService.deleteUserById(id);
	}

	@GetMapping("/byusername/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) throws UserNameNotFoundException {
		User user = this.userService.getUserByUserName(userName);

		if (user == null) {
			throw new UserNameNotFoundException("Username: '" + userName + "' not found");
		}

		return user;
	}
}
