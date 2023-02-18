package com.example.springboot2h.repositories;

import com.example.springboot2h.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer>{
    Optional<User> findByEmail(String email);
}
