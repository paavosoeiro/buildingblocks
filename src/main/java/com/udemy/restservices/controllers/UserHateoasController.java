package com.udemy.restservices.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.udemy.restservices.entities.Order;
import com.udemy.restservices.entities.User;
import com.udemy.restservices.exceptions.UserNotFoundException;
import com.udemy.restservices.services.UserService;

@RestController
@RequestMapping(value = "/hateoas/users")
@Validated
public class UserHateoasController {

	@Autowired
	private UserService userService;

	@GetMapping
	public Resources<User> getAllUsers() throws UserNotFoundException {
		List<User> users = this.userService.getAllUsers();

		for (User user : users) {
			Long userId = user.getUserId();
			Link selfLink = ControllerLinkBuilder.linkTo(getClass()).slash(userId).withSelfRel();
			user.add(selfLink);

			Resources<Order> orders = ControllerLinkBuilder.methodOn(OrderHateoasController.class).getAllOrders(userId);
			Link ordersLink = ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
			user.add(ordersLink);
		}
		
		Link self = ControllerLinkBuilder.linkTo(getClass()).withSelfRel();

		return new Resources<User>(users, self);
	}

	@GetMapping("/{id}")
	public Resource<User> getUserById(@PathVariable("id") @Min(1) Long id) {
		try {
			Optional<User> optionalUser = this.userService.getUserById(id);
			User user = optionalUser.get();
			Link selfLink = ControllerLinkBuilder.linkTo(getClass()).slash(user.getUserId()).withSelfRel();
			user.add(selfLink);

			return new Resource<User>(user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
