package com.dsp.theTipTop.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsp.theTipTop.entities.User;
import com.dsp.theTipTop.services.UserService;

@RestController
@RequestMapping(value = {"/users"})

@CrossOrigin
//@CrossOrigin(origins = "https://dsp4-5archio19-ah-je-gh-yb.fr", maxAge = 3600)
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping()
	public List<User> readAll() {
		return userService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<User> read(@PathVariable Long id) {
		return userService.findById(id);	
	}
	
	
	@PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody User user){
		return userService.save(user);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return userService.delete(id);
	} 
}
