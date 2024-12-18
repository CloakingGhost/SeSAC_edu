package org.example.inheritance;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void shout() {
        System.out.println("Cat Shout!");
    }

    public void purring() {
        System.out.println("purring");
    }
}
