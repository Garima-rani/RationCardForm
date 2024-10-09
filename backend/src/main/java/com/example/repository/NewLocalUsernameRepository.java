package com.example.repository;

import com.example.model.NewLocalUsername;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewLocalUsernameRepository extends JpaRepository<NewLocalUsername, Long> {
    // Additional query methods can be defined here if needed
}
