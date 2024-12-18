package org.example.prac1basic;

public class Triangle {
    // 정삼각형
    private int side;
    private int height;

    public Triangle(int side, int height) {
        this.side = side;
        this.height = height;
    }

    public int getBottom() {
        return side;
    }

    public void setBottom(int side) {
        this.side = side;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getArea() {
        return (double) side * height / 2;
    }

    public int getCircumference() {
        return side * 3;
    }

}
