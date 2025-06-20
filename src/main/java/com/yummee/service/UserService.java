package com.yummee.service;

import com.yummee.entity.User;

public interface UserService {
	
	User saveUser(User user);
    User loginUser(String username, String password);
    User getUserByUsername(String username);
    boolean isEmailTaken(String email);
    void deleteUserByUsername(String username);
}