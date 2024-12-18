package org.example.inheritance;

public class Truck extends Vehicle {
    private final int MAX_FUEL = 250;
    private int stuff;

    public Truck(String modelName, int speed, int fuel) {
        super(modelName, speed, fuel);
    }

    public void loading(){
        ++stuff;
    }
    public void unloading(){
        --stuff;
    }
}
