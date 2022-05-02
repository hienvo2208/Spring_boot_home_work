package com.techmasterles6.demo.entity;

import com.techmasterles6.demo.intefaces.Steering;

public class AutoSteering implements Steering {
    // Tính năng tự hành
    @Override
    public String driveMode() {
        return "Autopilot";
    }
}
