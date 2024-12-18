package org.example.inheritance;

public class Mage extends Character implements Attackable{
    private int mana;

    public Mage(String name) {
        super(name);
        super.health = 70;
        mana = 100;
    }

    // 원래는 부모클래스에서 메서드 재정의했음
    // 지금은 인터페이스의 메소드 재정의 함
    @Override
    public int attack() {
        mana -= 5;
        if (mana <= 0) {
            System.out.println("Not Enough Mana");
            mana = 0;
            return 0;
        }
        return super.attack();
    }

    @Override
    public int levelUp() {
        health += 15;
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
