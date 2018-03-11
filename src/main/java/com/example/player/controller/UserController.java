package com.example.player.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.player.exceptions.ResourceNotFoundException;
import com.example.player.model.User;
import com.example.player.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository ur;
	
	@PostMapping("/users/create")
	@ResponseBody
	public User createUser(@Valid @RequestBody User user) {
	    return ur.save(user);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long userId) {
	    User note = ur.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", userId));

	    ur.delete(note);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/users/{id}")
	public User updateNote(@PathVariable(value = "id") Long uid,
	                                        @Valid @RequestBody User newUser) {

	    User user = ur.findById(uid)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", uid));

	    user.setUsername(newUser.getUsername());
	    user.setPassword(newUser.getPassword());
	    user.setFavorite(newUser.getFavorite());

	    User updatedUser = ur.save(user);
	    return updatedUser;
	}
	
	

}
