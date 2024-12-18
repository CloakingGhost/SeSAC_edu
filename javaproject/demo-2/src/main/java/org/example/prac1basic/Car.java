package org.example.prac1basic;

public class Car {
    private final String modelName;
    private int speed;

    // 속도는 안 받아도 됨
    // 모든 변수에 대해 입력값을 받지 않아도 됨
    public Car(String modelName) {
        this.modelName = modelName;
        this.speed = 0;
        System.out.printf("%s ON\n", modelName);
    }

    public int increase(int speed) {
        return this.speed += speed;
    }

    public int decrease(int speed) {
        if (this.speed < speed) {
            this.speed = 0;
            return 0;
        }
        return this.speed -= speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", speed=" + speed +
                '}';
    }


}
