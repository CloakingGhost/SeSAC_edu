package org.example.composition;

public abstract class Weapon{
    protected int power;
    protected int durability;

    public Weapon(int power, int durability) {
        this.power = power;
        this.durability = durability;
    }

    public abstract int specialAttack();
    public abstract int attack();

    public abstract void decreaseDurability();
}
