package org.example.prac1basic;

public class Calculator2 {

// 설계도로 부터 만들어진 어떤 것 : 인스턴스
    // this에 의존하지 않은 메서드 : 클래스의 메서드, 스태틱 메서드, 인스턴스 없이 바로 사용함
    // 덧셈
    int add(int num1, int num2){
        return num1 + num2;
    }

    static int staticAdd(int num1, int num2) {
        return num1 + num2;
    }
    // 뺄셈
    int minus(int num1, int num2){
        return num1 - num2;
    }

    // 곱셈
    int multiply(int num1, int num2){
        return num1 * num2;
    }
    // 나눗셈
    int divide(int num1, int num2){
        return num1 / num2;
    }

}
