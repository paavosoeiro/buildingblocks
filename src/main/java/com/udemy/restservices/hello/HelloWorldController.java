package com.udemy.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.restservices.hello.model.UserDetails;

@RestController
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Paavo", "Silva", "Curitiba");
	}
}
