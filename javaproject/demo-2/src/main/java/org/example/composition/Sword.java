package org.example.composition;

public class Gun extends Weapon{
    public Gun(int power, int durability) {
        super(power, durability);
    }

    @Override
    public int specialAttack() {
        int damage = power * 2;
        System.out.println("Gun Special Damage " + damage);
        decreaseDurability();
        return damage;

    }

    @Override
    public int attack() {
        int damage = power;
        System.out.println("Gun Damage " + damage);
        decreaseDurability();
        return damage;
    }

    @Override
    public void decreaseDurability() {
        durability -= 2;
    }


}
