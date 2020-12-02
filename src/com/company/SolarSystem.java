package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SolarSystem implements Serializable {
    private ArrayList<Planet> planets = new ArrayList<>();

    public SolarSystem(List<Planet> planets) {
        this.planets.addAll(planets);
    }

    public void addPlanetToSystem(Planet planet) {
        this.planets.add(planet);
    }

    public void printPlanetName(int planetNumber) {
        if(planets.isEmpty()) {
            System.out.println("Планет в системе нет.");
            return;
        }
        if(planetNumber <= 0)
            planetNumber = 1;
        else if(planetNumber > planets.size())
            planetNumber = planets.size();
        System.out.println(planets.get(planetNumber - 1).getName());
    }

    public void printPlanetCount() {
        System.out.println(planets.size());
    }
}
