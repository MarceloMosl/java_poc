package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Users;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
