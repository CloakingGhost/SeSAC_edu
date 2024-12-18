package org.example.interface_abstract;

public class Rectangle extends Shape{
    public Rectangle() {
        width = 10;
        height = 20;
    }

    @Override
    public int calculateArea() {
        return width * height;
    }
}
