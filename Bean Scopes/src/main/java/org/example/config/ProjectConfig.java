package org.example.config;

import org.example.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.services")
public class ProjectConfig {

    @Bean
    public UserService userService1() {
        return new UserService();
    }

}
