package com.example.demo.controller;

import com.example.demo.model.request.RandomString;
import com.example.demo.service.RandomService;
import lombok.Getter;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RandomController {
    @Autowired
    private RandomService randomService;
    @PostMapping("/random")
    public ResponseEntity<?> getRandomString(@RequestBody RandomString rdst){
        String result = randomService.randomString(rdst);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/randomparam")
    public ResponseEntity<?> getPRandomString(){
        String result = randomService.randomPString();
        return ResponseEntity.ok("Cau: "+result);
    }


}
