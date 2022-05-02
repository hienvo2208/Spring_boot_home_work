package com.techmasterles6.demo.entity;

import com.techmasterles6.demo.intefaces.Steering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;

public class Car {
    private Engine engine;

    @Autowired
    @Lazy
    private StreetMap streetMap;

    @Autowired
    @Qualifier("autoSteering")
    private Steering steering;

    public Car(Engine engine) {
        this.engine = engine;
    }


    @Override
    public String toString() {
        return "Car [engine=" + engine.getEngine() + ", steering=" + steering.driveMode() + "]";
    }

    public String navigate() {
        return streetMap.getRoute();
    }
}