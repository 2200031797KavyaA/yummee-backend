package com.yummee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummee.entity.User;
import com.yummee.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean isEmailTaken(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void deleteUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}