package org.example.inheritance;

public class Vehicle {
    private final int MAX_FUEL = 100;
    private final int BASE_AMOUNT = 10;
    private String modelName;
    protected int speed;
    protected int fuel;

    public Vehicle(String modelName, int speed, int fuel) {
        this.modelName = modelName;
        this.speed = speed;
        this.fuel = fuel;
    }

    public int increaseSpeed() {
        return increaseSpeed(BASE_AMOUNT);
    }

    public int increaseSpeed(int amount) {
        speed += amount;
        if(speed >= 100){
            speed = 100;
        }
        return speed;
    }

    public int decreaseSpeed() {
        speed -= 10;
        if(speed <= 0){
            speed = 0;
        }
        return speed;

    }

}
