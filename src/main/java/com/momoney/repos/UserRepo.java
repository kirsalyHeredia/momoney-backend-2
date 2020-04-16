package com.momoney.repos;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momoney.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	//UserRepo inherits JpaRepo CRUD methods
	
}
