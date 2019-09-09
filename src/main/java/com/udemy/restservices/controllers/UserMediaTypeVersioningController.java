package com.udemy.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.restservices.dtos.UserDtoV1;
import com.udemy.restservices.dtos.UserDtoV2;
import com.udemy.restservices.entities.User;
import com.udemy.restservices.exceptions.UserNotFoundException;
import com.udemy.restservices.services.UserService;

@RestController
@RequestMapping("/versioning/mediatype/users")
@Validated
public class UserMediaTypeVersioningController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/{id}", produces = "application/vns.restservices.app-v1+json")
	public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		Optional<User> optionalUser = this.userService.getUserById(id);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		User user = optionalUser.get();

		UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);

		return userDtoV1;
	}

	@GetMapping(value = "/{id}", produces = "application/vns.restservices.app-v2+json")
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		Optional<User> optionalUser = this.userService.getUserById(id);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		User user = optionalUser.get();

		UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);

		return userDtoV2;
	}
}
