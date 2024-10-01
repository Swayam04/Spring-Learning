package org.example.config;

import org.example.entity.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@ComponentScan(basePackages = "org.example.entity")
@Configuration
public class ProjectConfig {

    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("Coco");
        return cat;
    }

    @Bean
    public Integer a() {
        return 10;
    }

    @Bean
    public Integer b() {
        return 20;
    }

    @Bean
    @Primary
    public Integer c() {
        return 4;
    }
}
