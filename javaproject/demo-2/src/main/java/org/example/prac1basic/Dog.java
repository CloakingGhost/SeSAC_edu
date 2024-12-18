package org.example.prac1basic;

public class Dog {
    static int count;
    private String breed;
    private String name;

    public Dog(String breed, String name) {
        this.breed = breed;
        this.name = name;
        count++; // 정적 변수 증가
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// 함수를 만들 때 미리 어떤 기능을 할지 정의가 된 상태에서 메소드를 만들어야 한다.
    public String command(String action) {
        return String.format("%s %s", name, action);
    }
}
