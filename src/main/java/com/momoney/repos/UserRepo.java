package com.momoney.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.momoney.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	
	Optional<User> findbyUserId(Long user_id);
	
}
