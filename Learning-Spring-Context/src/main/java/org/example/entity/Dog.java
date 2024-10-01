package org.example.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Dog {
    private String name;

    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        this.name = "Gudlu";
    }
}
