package org.example.auto.components;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
    private String name = "AMG 20 inch winter";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tyre type: " + name;
    }
}
