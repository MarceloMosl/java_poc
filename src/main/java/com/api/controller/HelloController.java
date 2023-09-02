package com.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.api.dtos.UserDto;
import com.api.models.Users;
import com.api.repository.UserRepo;

@RestController
@RequestMapping("/api")

public class HelloController {

    @Autowired
    private UserRepo repository;

    @GetMapping
    public String hello() {
        return "OK";
    }

    @PutMapping
    public List<Users> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> helloPost(@RequestBody UserDto req) {

        Users emailExists = repository.findByEmail(req.email());
        String errorMessage = "INVALID EMAIL";
        if (emailExists != null)
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of("message", errorMessage));

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(new Users(req)));
    }
}