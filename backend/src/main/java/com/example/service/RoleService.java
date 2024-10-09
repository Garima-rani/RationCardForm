package com.example.service;

import com.example.model.Role;
import com.example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * Creates a new role.
     */
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * Retrieves a role by its ID.
     */
    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
    }

    /**
     * Retrieves all roles.
     */
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    /**
     * Deletes a role by its ID.
     */
    public void deleteRole(Long id) {
        Role role = findById(id); // Check if the role exists
        roleRepository.delete(role);
    }
}
