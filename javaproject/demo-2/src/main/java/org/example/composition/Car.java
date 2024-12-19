package org.example.composition;

public class Car implements Tool {
    Engine engine;
    String modelName;

    public Car(String modelName, Engine engine) {
        this.modelName = modelName;
        this.engine = engine;
    }

    public void accelerate() {
        System.out.println("Increase Speed " + engine.getHorsepower() * 2);
    }

    public void setHorsepower(int horsepower) {
        engine.setHorsepower(horsepower);
    }

    @Override
    public void use() {
        accelerate();
    }
}
