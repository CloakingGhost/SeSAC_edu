package org.example.composition;

public abstract class Character {
    protected int health;
    protected Weapon weapon;

    public Character(int health, Weapon weapon) {
        this.health = health;
        this.weapon = weapon;
    }

    public abstract void attack(Character target);

    public abstract void specialAttack(Character target);

    public abstract void takeDamage(int amount);

}
