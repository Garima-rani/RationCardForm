package com.example.repository;

import com.example.model.NewMotherName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewMotherNameRepository extends JpaRepository<NewMotherName, Long> {
    // Additional query methods can be defined here if needed
}
