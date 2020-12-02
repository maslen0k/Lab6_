package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Planet moon = new Moon();
        Planet planet1 = new Planet("Planet 1");
        Planet planet2 = new Planet("Planet 2");
        SolarSystem solarSystem = new SolarSystem(List.of(moon, planet1));

        System.out.println("Количество планет в системе:");
        solarSystem.printPlanetCount();

        solarSystem.addPlanetToSystem(planet2);

        System.out.println("Количество планет в системе:");
        solarSystem.printPlanetCount();
        int planetNumber = 3;
        System.out.println("Название планеты №" + planetNumber);
        solarSystem.printPlanetName(planetNumber);

        System.out.println("Сериализация объекта");
        try {
            serialize(solarSystem, "lab6.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Десериализация объекта");
        try {
            SolarSystem newSolarSystem = deserialize("lab6.txt");
            if (newSolarSystem != null) {
                System.out.println("Количество планет в системе:");
                newSolarSystem.printPlanetCount();
            } else {
                System.out.println("Десериализация не удалась");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void serialize(SolarSystem solarSystem, String path) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(solarSystem);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if(fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            if(objectOutputStream != null) {
                objectOutputStream.flush();
                objectOutputStream.close();
            }
        }
    }

    public static SolarSystem deserialize(String path) throws IOException {
        SolarSystem solarSystem = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            solarSystem = (SolarSystem) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                fileInputStream.close();
            }
            if(objectInputStream != null) {
                objectInputStream.close();
            }
        }
        return solarSystem;
    }
}
