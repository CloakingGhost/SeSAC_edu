package org.example.composition;

public class Sword extends Weapon{
    public Sword(int power, int durability) {
        super(power, durability);
    }

    @Override
    public int specialAttack() {
        int damage = power * 2;
        System.out.println("Sword Special Damage " + damage);
        decreaseDurability();
        return damage;

    }

    @Override
    public int attack() {
        int damage = power;
        System.out.println("Sword Damage " + damage);
        decreaseDurability();
        return damage;
    }

    @Override
    public void decreaseDurability() {
        durability -= 2;
    }


}
