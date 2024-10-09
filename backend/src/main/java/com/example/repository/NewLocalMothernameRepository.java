package com.example.repository;

import com.example.model.NewLocalMothername;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewLocalMothernameRepository extends JpaRepository<NewLocalMothername, Long> {
    // Additional query methods can be defined here if needed
}
