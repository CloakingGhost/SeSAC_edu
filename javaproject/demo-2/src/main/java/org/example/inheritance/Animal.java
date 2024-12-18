package org.example.inheritance;

public class Animal {
    protected String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void shout() {
        System.out.println("shout");
    }

}
