package org.example.inheritance;

public class Parent {
    public String publicValue = "public";
    private String privateValue = "private";
    protected String protectedValue = "protected";

    public Parent(String publicValue) {
        this.publicValue = publicValue;
    }

    public void publicMethod() {
        System.out.println("public method");
    }

}
