package org.example.inheritance;

// extend 확장
public class Student extends Person{
    int studentNum;
//    String name;
//    int age;


    public static void introduce() {
        System.out.println("Hello, I'm Student");
    }

    public void study() {
        System.out.println("I'm Studying");
    }
}
