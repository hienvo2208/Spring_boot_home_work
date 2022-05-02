package com.techmasterles6.demo.configuration;

import com.techmasterles6.demo.entity.StreetMap;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class MapConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public StreetMap streetMap(){
        return new StreetMap();
    }
}
