package vn.techmaster.demobean.entity;

import vn.techmaster.demobean.interfaces.Steering;

public class AutoSteering implements Steering {
    @Override
    public String mode() {
        return "self-propelled mode";
    }
}
