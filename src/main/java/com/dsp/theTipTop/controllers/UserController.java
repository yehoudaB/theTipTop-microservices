package com.dsp.theTipTop.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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

@CrossOrigin()
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
	
   @GetMapping("/me")
    public Map<String, Object> userInfos(@AuthenticationPrincipal OAuth2User principal ) {
        //return Collections.singletonMap("name", principal.getAttribute("name") );
	   
        return principal.getAttributes();
        
    }
   
   
     @RequestMapping("/oauth2LoginSuccess")
     public Map<String, Object> saveUserData(@AuthenticationPrincipal OAuth2User principal) {
         //return Collections.singletonMap("name", principal.getAttribute("name") );
         return principal.getAttributes();
         
     }
}
