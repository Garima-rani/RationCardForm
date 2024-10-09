package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.NewUserName;

public interface NewUserNameRepository extends JpaRepository<NewUserName, Long> {
    // Additional query methods can be defined here if needed
}
