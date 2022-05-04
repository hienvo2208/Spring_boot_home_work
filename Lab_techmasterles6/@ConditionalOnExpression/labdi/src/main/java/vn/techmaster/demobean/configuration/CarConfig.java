package vn.techmaster.demobean.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import vn.techmaster.demobean.entity.Car;
import vn.techmaster.demobean.entity.Engine;


@Configuration
public class CarConfig {
    @Value("${engineType}")
    private String engineType;
    Engine engine;

    @Autowired
    private ApplicationContext context;

    @Bean
    @Primary
    public Car car() {
        switch (engineType) {
            case "gas":
                engine = (Engine) context.getBean("gasEngine");
                break;
            case "electric":
                engine = (Engine) context.getBean("electricEngine");
                break;
            case "hybrid":
                engine = (Engine) context.getBean("hybridEngine");
                break;
            default:
                engine = (Engine) context.getBean("gasEngine");
        }
        return new Car(engine);
    }

    @Bean
    public Car funCar() {
        return new Car((Engine) context.getBean("hybridEngine"));
    }


}
