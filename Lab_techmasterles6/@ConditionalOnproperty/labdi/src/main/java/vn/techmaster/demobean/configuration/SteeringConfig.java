package vn.techmaster.demobean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demobean.entity.AutoSteering;
import vn.techmaster.demobean.entity.ManualSteering;

@Configuration
public class SteeringConfig {
    @Bean("autoSteering")
    public AutoSteering autoSteering() {
        return new AutoSteering();
    }

    @Bean("manualSteering")
    public ManualSteering manualSteering() {
        return new ManualSteering();
    }
}
