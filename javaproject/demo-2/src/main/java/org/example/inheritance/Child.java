package org.example.inheritance;

public class Child extends Parent {
    public String childValue = "childValue";

    public Child(String publicVales){
        super(publicVales);

    }
    public void childMethod() {
        System.out.println("child Method");
    }

    // 부모의 메소드를 덮어 씌워 사용
    // 메소드 오버라이딩
    public void publicMethod() {
        // 부모에게 접근
        super.publicMethod();
        System.out.println(super.publicValue);
        System.out.println(super.protectedValue);
        System.out.println("child public method");
    }
}
