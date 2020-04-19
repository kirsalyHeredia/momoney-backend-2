package com.momoney.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.momoney.models.User;
import com.momoney.repos.UserRepo;


@Configuration
@EnableConfigurationProperties
@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	//creates user object in db from fields entered in frontend
	public User createUser (User user) {
		
		return this.userRepo.save(user);
	}
	
	public Optional<User> getUserbyId(long id){
		return this.userRepo.findById(id);
		
	}
	
	public void hasPassword(String password) {
		
	}
	
	public User setPassword(User clientUser) {
		//Create user object with Optional type b/c Optional can return the obj or a null
		//reference the userRepo with this to ensure it refs the variable in service and its inherited methods
		Optional <User> user = this.userRepo.findById(clientUser.getUserId());
		
		//assign the hashed password to a variable hashedPass
		String hashedPass = BCrypt.hashpw(clientUser.getPassword(), BCrypt.gensalt());
		
		//set updated & hashed password into the user obj
		user.get().setPassword(hashedPass);
		
		//save the user object with the new password & assign user obj to resp variable
		User resp = this.userRepo.save(user.get());
		
		//return the updated user object
		return resp;	
				
	}
	
	
	@Transactional
	public User updateUser (User clientUser) {
		//finds user by id in db
		Optional <User> user = this.userRepo.findById(clientUser.getUserId());
		
//		String fName = clientUser.getfName();
//		String lName = clientUser.getlName();
//		String dob = clientUser.getDob();
//		String email = clientUser.getEmail();
//		String username = clientUser.getUsername();
		User resp = this.userRepo.save(user.get());
		
		return resp;//come back and change this line
	}
	
	
	
	
	
	
	
	
	
	
//	public boolean checkValues(User clientUser)
//	{
//		String firstName = clientUser.getfName();
//		String lastName = clientUser.getlName();
//		String email = clientUser.getEmail();
//		long phoneNumber = clientUser.getPhoneNumber();
//		String dob = clientUser.getDob();
//		String username = clientUser.getUsername();
//		String password = clientUser.getPassword();
//		String streetAddress = clientUser.getStreetAddress();
//		String city = clientUser.getCity();
//		String state = clientUser.getState();
//		int zipCode = clientUser.getZip();
//		long ssn = clientUser.getSSN();
//		SecurityQuestion securityQuestion = clientUser.getSecurityQuestion();
//		String securityAnswer = clientUser.getSecurityAnswer();
//		
//		
//		System.out.println(firstName.length());
//		System.out.println(lastName.length());
//		System.out.println(lastName.length());
//		System.out.println(email.length());
//		System.out.println(streetAddress.length());
//		System.out.println(city.length());
//		System.out.println(phoneNumber.length());
//		System.out.println(zipCode.length());
//		
//		if(firstName.length() <= 0 || lastName.length() <= 0 || email.length() <= 0 
//				|| address.length() <= 0 || city.length() <= 0 || phoneNumber.length() <= 0 || zipCode.length() <= 0)
//		{
//			return false;
//		}else return true;
//	}
	
	
	
	
	
}
