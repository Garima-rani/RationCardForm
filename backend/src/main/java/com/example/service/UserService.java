package com.example.service;

import com.example.model.Role;
import com.example.model.TheUser;
import com.example.model.UserDto;
import com.example.model.UserRequest;
import com.example.model.UserRole;
import com.example.model.UserRoleId;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.repository.UserRequestRepository;
import com.example.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRequestRepository userRequestRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // For password encoding

    public List<TheUser> findAll() {
        return userRepository.findAll();
    }

    public TheUser findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public TheUser updateUser(Long id, UserDto userDto) {
        TheUser user = findById(id);
        // Update user fields from userDto
        user.setUsername(userDto.getUsername());
        // Add other fields as necessary
        return userRepository.save(user);
    }

    public TheUser registerUser(TheUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public TheUser authenticateUser(String username, String password) {
        TheUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return user; // Return the authenticated user
    }

    public List<UserRequest> getPendingRequests() {
        return userRequestRepository.findAll();
    }

    public void approveRequest(Long requestId) {
        UserRequest request = userRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found with id: " + requestId));
        request.setStatus("APPROVED");
        userRequestRepository.save(request);
    }

    public void declineRequest(Long requestId) {
        UserRequest request = userRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found with id: " + requestId));
        request.setStatus("DECLINED");
        userRequestRepository.save(request);
    }

    public void assignRoleToUser(Long userId, Long roleId) {
        TheUser user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        UserRoleId userRoleId = new UserRoleId(user.getId(), role.getId());
        UserRole userRole = new UserRole(userRoleId, user, role);
        userRoleRepository.save(userRole);
    }
}
