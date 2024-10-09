package com.example.controller;

import com.example.model.TheUser;
import com.example.model.UserDto;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<TheUser>> getAllUsers() {
        List<TheUser> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheUser> getUserById(@PathVariable Long id) {
        TheUser user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheUser> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        TheUser updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/register")
    public ResponseEntity<TheUser> registerUser(@RequestBody TheUser user) {
        TheUser registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<TheUser> authenticateUser(@RequestParam String username, @RequestParam String password) {
        TheUser authenticatedUser = userService.authenticateUser(username, password);
        return ResponseEntity.ok(authenticatedUser);
    }
}
