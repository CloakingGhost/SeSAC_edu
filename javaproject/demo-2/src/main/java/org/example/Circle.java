package org.example;

/*
* 역할과 책임을 분리하고
* 관리를 용이하게 하기위해
*/
public class Circle {
    int radius;

    Circle(int radius){
        // 인스턴스 자신을 부를 때 설계도에서 this라고 한다.
        this.radius = radius;
    }
    double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
