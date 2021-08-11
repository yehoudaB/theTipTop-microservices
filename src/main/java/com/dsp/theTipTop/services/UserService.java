package com.dsp.theTipTop.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsp.theTipTop.entities.User;
import com.dsp.theTipTop.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Transactional
	public ResponseEntity<String> save(@Valid User pUser) {
		User user = userRepository.save(pUser);
		if(user == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when saving the user");
		}
		return ResponseEntity.ok().body(user.getId().toString());
	}

	@Transactional
	public ResponseEntity<String> delete(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("non-existent user with id : "+ id );
		} 
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

}
