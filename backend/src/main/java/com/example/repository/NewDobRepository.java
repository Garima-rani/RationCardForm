package com.example.repository;

import com.example.model.NewDob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewDobRepository extends JpaRepository<NewDob, Long> {
    // Additional query methods can be defined here if needed
}
