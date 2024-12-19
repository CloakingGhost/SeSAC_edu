package org.example.composition;

public class Main {
    public static void main(String[] args) {
        Pencil red = new Pencil("red");
        Person beemo = new Person("beemo", red);

        beemo.write();

        Pencil blue = new Pencil("blue");
        beemo.setPencil(blue);

        beemo.write();
        System.out.println();

        Pencil yellow = new Pencil("yellow");

        Pencil[] pencils = {red, blue, yellow};
        Person lynda = new Person("lynda", pencils);

        lynda.writeMany();
        System.out.println();

        Engine engine = new Engine(10);
        Car car = new Car("Avente", engine);
        car.accelerate();
        car.setHorsepower(30);
        car.accelerate();
        System.out.println();


        Gun gun = new Gun(30, 100);
        Gunner gunner = new Gunner(300, gun);

        Sword sword = new Sword(30, 100);
        Warrior warrior = new Warrior(500, sword);

        gunner.attack(warrior);
        System.out.println(warrior.health);
        gunner.specialAttack(warrior);
        System.out.println(warrior.health);
        System.out.println();

        warrior.attack(gunner);
        System.out.println(gunner.health);
        warrior.specialAttack(gunner);
        System.out.println(gunner.health);

        Person p1 = new Person("123", red);
        System.out.println(((Pencil)(p1.tool)).color);



    }
}
