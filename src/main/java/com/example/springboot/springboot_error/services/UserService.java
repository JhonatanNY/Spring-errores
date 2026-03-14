package com.example.springboot.springboot_error.services;

import java.util.List;

import com.example.springboot.springboot_error.models.domain.User;

public interface UserService {

    List<User>findAll();
    User findById(Long id);
}
