package com.techmasterles6.demo.controller;

import com.techmasterles6.demo.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    Car car;

    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHome(){
        return car.toString();
    }
}
