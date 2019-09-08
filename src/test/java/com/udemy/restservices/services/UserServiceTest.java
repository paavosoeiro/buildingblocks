package com.udemy.restservices.services;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.udemy.restservices.entities.User;
import com.udemy.restservices.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Before
	public void setUp() {
		List<User> list = Arrays.asList(new User("Paavo"), new User("Buiu"));
		when(userRepository.findAll()).thenReturn(list);
		when(userRepository.save(any(User.class))).thenReturn(new User("Paavo"));
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = userService.getAllUsers();
		assertNotNull("Lista não deve ser null", users);
	}

	@Test
	public void testCreateUser() {
		assertThat(userService.createUser(new User()).getFirstName(), is(equalTo("Paavo")));
	}

}
