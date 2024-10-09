package com.example.repository;

import com.example.model.NewLocalFathername;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewLocalFathernameRepository extends JpaRepository<NewLocalFathername, Long> {
    // Additional query methods can be defined here if needed
}
