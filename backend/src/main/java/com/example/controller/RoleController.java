package com.example.controller;

import com.example.model.Role;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role newRole = roleService.createRole(role);
        return ResponseEntity.ok(newRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.findById(id);
        return ResponseEntity.ok(role);
    }
}
