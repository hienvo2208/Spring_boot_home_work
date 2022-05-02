package com.techmasterles6.demo.entity;

import com.techmasterles6.demo.intefaces.Steering;

public class ManualSteering implements Steering {
    @Override
    public String driveMode() {
        // Tính năng số tự động
        return "Automatic Transmission";
    }
}
