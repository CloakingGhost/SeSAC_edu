package org.example.inheritance;

public class Dog extends Animal{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void shout(){
        System.out.println(name + " Shout");
    }

}
