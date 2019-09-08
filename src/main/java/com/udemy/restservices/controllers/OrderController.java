package com.udemy.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.restservices.entities.Order;
import com.udemy.restservices.entities.User;
import com.udemy.restservices.exceptions.OrderNotFoundException;
import com.udemy.restservices.exceptions.UserNotFoundException;
import com.udemy.restservices.repositories.OrderRepository;
import com.udemy.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		return userOptional.get().getOrders();
	}

	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
	}

	@GetMapping("/{userId}/orders/{orderId}")
	public Order getOrderByOrderId(@PathVariable Long userId, @PathVariable Long orderId)
			throws UserNotFoundException, OrderNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		Optional<Order> optionalOrder = orderRepository.findById(orderId);

		if (!optionalOrder.isPresent()) {
			throw new OrderNotFoundException("Order Not Found");
		}

		return optionalOrder.get();
	}
}
