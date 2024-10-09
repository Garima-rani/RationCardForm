package com.example.repository;

import com.example.model.NewGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewGenderRepository extends JpaRepository<NewGender, Long> {
    // Additional query methods can be defined here if needed
}
