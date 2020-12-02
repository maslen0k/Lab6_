package com.company;

import java.io.Serializable;

public class Planet implements Serializable {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
