package com.api.models;

import com.api.dtos.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity

@NoArgsConstructor

public class Users {

    public Users(UserDto req) {

        this.name = req.name();
        this.email = req.email();
        this.age = req.age();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

}
