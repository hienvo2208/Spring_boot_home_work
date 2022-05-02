package com.techmasterles6.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Engine {
    private String Engine;

    public Engine() {
    }

    public Engine(String engine) {
        Engine = engine;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }
}
