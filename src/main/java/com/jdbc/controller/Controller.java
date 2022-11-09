package com.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.model.User;
import com.jdbc.service.UserService;


@RestController
public class Controller {
	
	@Autowired
	UserService userService;
	
	

	@PostMapping("/create")
	public User addUser(@RequestBody User user) {
		
		return userService.createUser(user);

	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);

	}

//	@GetMapping("/{id}")
//	public User getUser(@PathVariable("id") int id) {
//		return userService.getById(id);
//	}
//
	@GetMapping(value ="/fetch")
	public List<User> getUsers() {
		return userService.getUser();
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		 userService.deleteUser(id);
	}

	
	
}
