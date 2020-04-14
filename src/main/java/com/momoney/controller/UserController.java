package com.momoney.controller;

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
import com.momoney.service.UserService;

@RestController

@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userServ;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user){
		boolean validationCheck = userServ.checkValues(user);
		
		if (validationCheck) {
			// need to install BCrypt
			// user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			
			User createdUser = userServ.createUser(user);
			/**
			 * Hash password using BCrypt library
			 */
			
			return new ResponseEntity<User>(createdUser ,HttpStatus.OK);
		}
		else return new ResponseEntity<User>(new User(), HttpStatus.PARTIAL_CONTENT);

	}
	
	@GetMapping("/{email}")
	public ResponseEntity<User> getUser(@PathVariable(value="email") String email)
	{
		Optional<User> user = userServ.getUserByEmail(email);
		User foundUser = user.get();
		return new ResponseEntity<User>(foundUser, HttpStatus.OK);
	}
	
	@PostMapping(value="/updatePassword", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> updatePassword(@RequestBody User clientUser) {
		User user = userServ.setPassword(clientUser);
		return  new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/updateUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> updateUserInformation(@RequestBody User clientUser) {
		User user = userServ.updateUser(clientUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
