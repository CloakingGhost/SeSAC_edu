package org.example.interface_abstract;

public class Triangle extends Shape{
    private int width;
    private int height;
    public Triangle() {
        width = 10;
        height = 20;
    }

    @Override
    public int calculateArea() {
        return width * height;
    }
}
