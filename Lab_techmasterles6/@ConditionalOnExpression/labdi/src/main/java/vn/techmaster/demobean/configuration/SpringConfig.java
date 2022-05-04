package vn.techmaster.demobean.configuration;


import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demobean.entity.Module;


@Configuration
@ConditionalOnExpression(value = "${module.enabled:true} and ${module.submodule.enabled:true}")
public class SpringConfig {
    @Bean
    public Module module(){
        return new Module();
    }
}
