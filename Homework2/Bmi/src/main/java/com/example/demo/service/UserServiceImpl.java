package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.model.CreateUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Boolean createUser(CreateUser createUser) {
        double bimIndex = createUser.getWeight()/(Math.pow(createUser.getHeight(),2));
        User newUser = new User();
        newUser.setBmi(bimIndex);
        newUser.setName(createUser.getName());
        newUser.setWeight(createUser.getWeight());
        newUser.setHeight(createUser.getHeight());
        userRepository.save(newUser);
        return true;
    }

    @Override
    public Optional<User> findUserById(int id) {
        Optional<User> result = userRepository.findById(id);
        return result;
    }
}
