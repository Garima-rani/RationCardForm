package com.example.Security;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.ERole;
import com.example.model.Role;
import com.example.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Define the required roles
        List<ERole> requiredRoles = Arrays.asList(ERole.ROLE_ADMIN, ERole.ROLE_EDITOR, ERole.ROLE_VIEWER);

        // Fetch existing roles
        List<Role> existingRoles = roleRepository.findAll();

        if (existingRoles.isEmpty()) {
            // If no roles exist, create and save them
            for (ERole eRole : requiredRoles) {
                Role role = new Role();
                role.setName(eRole);
                roleRepository.save(role);
            }
            logger.info("Roles (ADMIN, EDITOR, VIEWER) populated successfully.");
        } else {
            logger.info("Roles already exist in the database.");
        }
    }
}
