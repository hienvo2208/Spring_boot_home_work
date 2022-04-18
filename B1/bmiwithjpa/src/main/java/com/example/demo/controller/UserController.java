package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.model.CreateUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody CreateUser createUser){
        boolean check =  userService.createUser(createUser);
        if(check){
            return ResponseEntity.ok("Tao thanh cong");
        }else{
            return  ResponseEntity.ok("Tao that bai");
        }
    }
    @GetMapping("/bmi")
    public ResponseEntity<?> getUser(@RequestParam(name ="a") int a) {
        Optional<User> result =  userService.findUserById(a);
        return ResponseEntity.ok(result);
    }

}
