package com.example.repository;

import com.example.model.NewFatherName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewFatherNameRepository extends JpaRepository<NewFatherName, Long> {
    // Additional query methods can be defined here if needed
}
