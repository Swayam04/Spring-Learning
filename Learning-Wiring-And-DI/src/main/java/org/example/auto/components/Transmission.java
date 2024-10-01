package org.example.auto.components;

import org.springframework.stereotype.Component;

@Component
public class Transmission {
    private String name = "9-speed Mercedes AMG Speedshift MCT";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Transmission: " + name;
    }
}
