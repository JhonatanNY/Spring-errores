package com.example.springboot.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.example.springboot.springboot_error.models.domain.User;

public interface UserService {

    List<User>findAll();
    Optional<User> findById(Long id);
}
