package com.example.player.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.player.repository.UserRepository;
import com.example.player.web.model.User;

public class UserController {
	
	@Autowired
	UserRepository ur;
	
	@PostMapping("/users/create")
	public User createUser(@Valid @RequestBody User user) {
	    return ur.save(user);
	}

}
