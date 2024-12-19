package org.example.composition;

public class Warrior extends Character {
    public Warrior(int health, Weapon weapon) {
        super(health, weapon);
    }

    @Override
    public void attack(Character target) {
        System.out.println("Gunner Attack");
        target.takeDamage(weapon.attack() + 15);
    }

    @Override
    public void specialAttack(Character target) {
        System.out.println("Gunner Attack");
        target.takeDamage(weapon.specialAttack() + 5);
    }

    @Override
    public void takeDamage(int amount) {
        health -= amount - 15;
    }

}
