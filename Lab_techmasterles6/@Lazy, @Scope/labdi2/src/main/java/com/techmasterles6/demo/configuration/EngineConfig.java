package com.techmasterles6.demo.configuration;

import com.techmasterles6.demo.entity.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EngineConfig {
    // Động cơ: Đốt trong
    @Bean("internalCombustionEngine")
    public Engine internalCombustionEngine(){
        return new Engine("BMW Electric Engine");
    }


    // Động cơ: Điện
    @Bean(name = "electricEngine")
    public Engine teslaEngine() {
        return new Engine("Tesla Electric Engine");
    }


    //Đông cơ: Điện + đốt trong
    @Bean(name = "hybridEngine")
    public Engine hybridEngine() {
        return new Engine("Hybrid Engine");
    }

}
