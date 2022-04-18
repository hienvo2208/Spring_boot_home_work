package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.model.CreateUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    public Boolean createUser(CreateUser createUser);
    public Optional<User> findUserById(int id);
}
