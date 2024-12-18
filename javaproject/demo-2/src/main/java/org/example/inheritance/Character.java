package org.example.inheritance;

public class Character {
    private static final int DEFAULT_ATTACK_DAMAGE = 20;
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int level;
    protected int currentExperience;
    protected int requiredExperience;
    protected int experiencePoint;

    public Character(String name) {
        this.name = name;
        level = 1;
        currentExperience = 0;
        requiredExperience = 100;
        experiencePoint = 10;
        health = 100;
    }

    // 모든 캐릭터는 attack이 필요하다
    // 공격은 각 직업마다 정해진다
    // 무엇은 구현해야 하는지 정해놓은 명세: interface
    // 통일성을 갖추게 하고 강제성을 부여한다, 네이밍 규칙이 지켜지기 힘들다
    //
    protected int attack() {
        System.out.println(name + " Attack!");
        return Character.DEFAULT_ATTACK_DAMAGE;
    }

    // 내 캐릭터의 공격력만큼 상대의 체력 감소
    public void hit(Character character) {

        character.setHealthy(character.getHealthy() - attack());
        System.out.println("character.getHealthy() = " + character.getHealthy());
    }

    public int levelUp() {
        currentExperience = 0;
        requiredExperience = (int) (requiredExperience * 1.2);

        ++level;
        experiencePoint += level * 3;
        return level;
    }

    public int getHealthy() {
        return -1;
    }

    public void setHealthy(int healthy) {

    }
}
