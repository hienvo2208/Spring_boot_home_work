package vn.techmaster.demobean.entity;

import vn.techmaster.demobean.interfaces.Steering;

public class ManualSteering implements Steering {

    @Override
    public String mode() {
        return "Manual steering.";
    }
}
