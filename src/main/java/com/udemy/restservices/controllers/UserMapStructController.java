package com.udemy.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.restservices.dtos.UserMsDto;
import com.udemy.restservices.entities.User;
import com.udemy.restservices.mappers.UserMapper;
import com.udemy.restservices.repositories.UserRepository;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@GetMapping
	public List<UserMsDto> getAllUserDtos() {
		return userMapper.usersToUserDtos(userRepository.findAll());
	}

	@GetMapping("/{id}")
	public UserMsDto getUserById(@PathVariable Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.get();
		return userMapper.userToUserMsDto(user);
	}

}
