package com.example.service;

import com.example.Security.JwtUtil;
import com.example.model.AuthResponse;
import com.example.model.ERole;
import com.example.model.Role;
import com.example.model.TheUser;
import com.example.model.UserDto;
import com.example.model.UserRole;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtUtil jwtUtil;

    public TheUser registerUser(UserDto userDto) {
        // Check if username already exists
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Create a new user
        TheUser user = new TheUser();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        
        // Assign roles
        Set<UserRole> userRoles = new HashSet<>();
        Role role = roleRepository.findByName(ERole.valueOf(userDto.getRole()))
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        
        userRoles.add(userRole);
        user.setUserRoles(userRoles);

        // Save user
        return userRepository.save(user);
    }

   
    public AuthResponse authenticateUser(String username, String password) {
        System.out.println("Attempting to authenticate user: " + username);
        TheUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        if (!encoder.matches(password, user.getPassword())) {
            System.out.println("Invalid password");
            throw new RuntimeException("Invalid credentials");
        }

        // Generate the token
        String token = jwtUtil.generateToken(user.getUsername());

        // Extract user roles
        Set<String> roles = user.getUserRoles().stream()
                .map(userRole -> userRole.getRole().getName().name())
                .collect(Collectors.toSet());

        // Return the token, username, and roles
        return new AuthResponse(token, user.getUsername(), roles);
    }


}