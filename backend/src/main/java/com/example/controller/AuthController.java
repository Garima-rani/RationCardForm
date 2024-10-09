package com.example.controller;

import com.example.model.AuthResponse;
import com.example.model.TheUser;
import com.example.model.UserDto;
import com.example.model.UserResponseDto;
import com.example.service.AuthService;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserDto userDto) {
        try {
            TheUser registeredUser = authService.registerUser(userDto);
            UserResponseDto responseDto = new UserResponseDto(
                registeredUser.getId(),
                registeredUser.getUsername(),
                registeredUser.getCreatedAt(),
                registeredUser.getUserRoles().stream()
                    .map(role -> role.getRole().getName().name())
                    .collect(Collectors.toSet())
            );
            return ResponseEntity.ok(responseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Consider returning a structured error response
        }
    }

    @PostMapping("/official-login")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody UserDto userDto) {
        try {
            AuthResponse authResponse = authService.authenticateUser(userDto.getUsername(), userDto.getPassword());
            return ResponseEntity.ok(authResponse);
        } catch (RuntimeException e) {
            System.out.println("Authentication error: " + e.getMessage());
            return ResponseEntity.badRequest().body(new AuthResponse(null, e.getMessage(), null)); // Adjust the error response
        }
    }

}
