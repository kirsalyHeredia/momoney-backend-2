package com.momoney.services;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momoney.models.User;
import com.momoney.repos.UserRepo;



@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	//creates user object in db from fields entered in frontend
	public User createUser (User user) {
		
		return this.userRepo.save(user);
	}
	
	@Transactional
	public User updateUser (User clientUser) {
		return clientUser;//come back and change this line
	}
}
