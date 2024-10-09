package com.example.repository;

import com.example.model.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {
    // Add custom query methods if needed
}
