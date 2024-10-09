package com.example.repository;

import com.example.model.NewEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewEmailRepository extends JpaRepository<NewEmail, Long> {
    // Additional query methods can be defined here if needed
}
