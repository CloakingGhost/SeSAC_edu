package org.example.inheritance;

import org.example.prac1basic.Calculator;

public class Main {
    public static void main(String[] args) {
        Person.introduce();
        Student.introduce();

        Student s = new Student();
        s.study();


        System.out.println("parent");
        Parent parent = new Parent("parent");


        Character c1 = new Warrior("warrior");
        Character c2 = new Mage("mage");
        System.out.println("c2.getHealthy() = " + c2.getHealthy());
        c1.hit(c2);
        System.out.println("c2.getHealthy() = " + c2.getHealthy());
        System.out.println("c1.getHealthy() = " + c1.getHealthy());
        c2.hit(c1);
        System.out.println("c1.getHealthy() = " + c1.getHealthy());

    }
}
