package com.example.springboot.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;

    public UserServiceImpl() {

    }

    @Override
    public List<User> findAll() {

        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = users.stream().filter(a -> a.getId().equals(id)).findFirst();      
        return user;
    }

}
