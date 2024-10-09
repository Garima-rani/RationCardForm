package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.TheUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<TheUser, Long> {
   
	Optional<TheUser> findByUsername(String username);

}
