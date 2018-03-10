package com.example.player.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.player.model.User;
import com.example.player.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository ur;
	
	@GetMapping("/users")
	@ResponseBody
	public String hello() {
	    return "hello";
	}
	
	@PostMapping("/users/create")
	@ResponseBody
	public User createUser(@Valid @RequestBody User user) {
	    return ur.save(user);
	}

}
