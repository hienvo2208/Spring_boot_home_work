package com.techmasterles6.demo.configuration;

import com.techmasterles6.demo.entity.Car;
import com.techmasterles6.demo.entity.Engine;
import com.techmasterles6.demo.intefaces.Steering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CarConfig {
//    @Value("${engineType}")
//    private String engineType;

    @Autowired
    ApplicationContext context;

    @Bean
    public Car carTn1() {
        return new Car((Engine) context.getBean("electricEngine"));
    }

    @Bean
    @Primary
    public Car funCar() {
        return new Car((Engine) context.getBean("hybridEngine"));
    }

//    @Bean
//    public Car car() {
//        Engine engine;
//        switch (engineType) {
//            case "gas":
//                engine = (Engine) context.getBean("gasEngine");
//                break;
//            case "electric":
//                engine = (Engine) context.getBean("electricEngine");
//                break;
//            case "hybrid":
//                engine = (Engine) context.getBean("hybridEngine");
//                break;
//            default:
//                engine = (Engine) context.getBean("gasEngine");
//        }
//
//        return new Car(engine);
//    }


}
