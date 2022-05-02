package com.techmasterles6.demo.configuration;

import com.techmasterles6.demo.entity.AutoSteering;
import com.techmasterles6.demo.entity.ManualSteering;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SteeringConfig {
    @Bean("autoSteering")
    public AutoSteering autoSteering(){
        return new AutoSteering();
    }

    @Bean("manualSteering")
    public ManualSteering manualSteering(){
        return new ManualSteering();
    }


}
