package com.yummee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yummee.entity.User;
import com.yummee.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/email-taken")
    public ResponseEntity<Boolean> isEmailTaken(@RequestParam String email) {
        boolean taken = userService.isEmailTaken(email);
        return ResponseEntity.ok(taken);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/register")
    public ResponseEntity<String> testRoute() {
        return ResponseEntity.ok("You hit the register route via GET");
    }
}