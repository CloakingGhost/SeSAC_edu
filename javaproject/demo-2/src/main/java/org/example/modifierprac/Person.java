package org.example.modifierprac;

public class Person {
    private String name;
    public int age;
    double height;

    public Person(){}
    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    private void run(){
        System.out.println("run");
    }

    public void walk() {
        System.out.println("walk");
    }

    void study() {
        System.out.println("study");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void exercise(){
        run();
    }
}
