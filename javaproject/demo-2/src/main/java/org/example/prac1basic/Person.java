package org.example.prac1basic;

public class Person {
    private String name;
    private byte age;

    public Person(String name, byte age) {
        this.name = name;
        this.age = age;
    }
    public Person() {
        this.name = "basic name";
        this.age = 4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
