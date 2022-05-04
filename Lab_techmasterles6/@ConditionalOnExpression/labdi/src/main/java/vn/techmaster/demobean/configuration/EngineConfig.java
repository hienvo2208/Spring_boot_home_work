package vn.techmaster.demobean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demobean.entity.Engine;

@Configuration
public class EngineConfig {
    @Bean("gasEngine")
    public Engine gasEngine() {
        return new Engine("Gas");
    }
    @Bean(name = "electricEngine")
    public Engine teslaEngine() {
        return new Engine("Tesla Electric Engine");
    }
    @Bean(name = "hybridEngine")
    public Engine hybridEngine() {
        return new Engine("Hybrid Engine");
    }

}
