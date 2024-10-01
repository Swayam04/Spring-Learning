package org.example.auto.components;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private int horsePower = 577;
    private String name = "M177 V8 Biturbo";


    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Engine: " + name + " Power: " + horsePower + " HP";
    }
}
