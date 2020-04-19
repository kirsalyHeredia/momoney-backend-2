package com.momoney.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.momoney.models.User;
import com.momoney.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/momoney")
public class UserController {
	
	
	@Autowired
	private UserService userServ;
	
	
	//creating a new user in db
	@PostMapping(consumes = "application/son", produces = "application/json")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user){
			//creates user object to add to database
			User createdUser = userServ.createUser(user);
			return new ResponseEntity<User>(createdUser,HttpStatus.OK);		
	}
	
	
	//getting a user form the db
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable(value="user_id") long userId){
		Optional<User> user = userServ.getUserbyId(userId);
		User foundUser = user.get();
		return new ResponseEntity<User>(foundUser, HttpStatus.OK);		
	}
	
	//updates user's info
	@PostMapping(value = "/updateUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> updateUserInfo(@RequestBody User clientUser){
		User user = userServ.updateUser(clientUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	//updates the user's password
	@PostMapping(value="/updatePassword", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> updatePassword(@RequestBody User clientUser){
		User user = userServ.setPassword(clientUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
};