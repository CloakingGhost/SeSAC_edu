package org.example.inheritance;

public class Warrior extends Character {
    private int rage;
    private static final int MAX_RAGE = 100;
    private final static double ATTACK_BENEFIT = 1.1;

    public Warrior(String name) {
        super(name);
        super.health = 120;
        super.maxHealth = 120;
        rage = 0;
    }


    @Override
    public int attack() {
        rage += 10;
        if(rage >= MAX_RAGE){
            rage = MAX_RAGE;
        }
        return (int) (Warrior.ATTACK_BENEFIT * super.attack());
    }

    @Override
    public int levelUp() {
        maxHealth += 30;
        return super.levelUp();
    }
    @Override
    public int getHealthy() {
        return health;
    }
    @Override
    public void setHealthy(int health) {
        this.health = health;
    }
}
