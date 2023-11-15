package com.example.apiproject.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfiguration {

    @Bean
    public GroupedOpenApi usersOpenApi() {
        String[] packagesToScan = {"com.example.apiproject.controller"};
        return GroupedOpenApi.builder()
                .group("users")
                .packagesToScan(packagesToScan)
                .build();
    }
}
