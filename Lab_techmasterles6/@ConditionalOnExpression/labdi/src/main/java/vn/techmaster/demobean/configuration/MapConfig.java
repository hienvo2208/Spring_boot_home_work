package vn.techmaster.demobean.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import vn.techmaster.demobean.entity.StreetMap;

@Configuration
public class MapConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public StreetMap streetMap() {
        return new StreetMap();
    }
}
