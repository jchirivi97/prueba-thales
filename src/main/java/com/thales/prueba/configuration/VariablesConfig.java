package com.thales.prueba.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VariablesConfig {

    @Value("${spring.rest.url.all}")
    private String urlAll;

    @Value("${spring.rest.url.employee}")
    private String urlEmployee;

    public String getUrlAll(){
        return urlAll;
    }

    public String getUrlEmployee(){
        return urlEmployee;
    }

}
