package vn.techmaster.demobean.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import vn.techmaster.demobean.interfaces.Steering;

public class Car {
    private Engine engine;

    @Autowired
    @Lazy
    private StreetMap streetMap;

    @Autowired
    @Qualifier("manualSteering")
    private Steering steering;

    public Car() {
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine.getEngine() + ", steering=" + steering.mode() + "]";
    }

    public String navigate() {
        return streetMap.getRoute();
    }
}
