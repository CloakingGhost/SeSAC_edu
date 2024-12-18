package org.example.inheritance;

public class Bus extends Vehicle {
    private final int MAX_FUEL = 300;
    private int passenger;

    public Bus(String modelName, int speed, int fuel) {
        super(modelName, speed, fuel);
        passenger = 0;
    }

    public void getOn() {
        ++passenger;
    }

    public void getOff() {
        --passenger;

    }
}
