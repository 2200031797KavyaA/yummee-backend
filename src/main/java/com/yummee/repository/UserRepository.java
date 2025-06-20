package com.yummee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummee.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	boolean existsByEmail(String email);
	
}