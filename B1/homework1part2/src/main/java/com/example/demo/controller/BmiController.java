package com.example.demo.controller;

import com.example.demo.Entity.Bmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BmiController {
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

    @PostMapping("/bmi")
    public ResponseEntity<?> findBmi(@RequestBody FindUser findUser){
        Bmi result = userService.IbmOfUser(findUser);
        return ResponseEntity.ok(result);
    }
}
