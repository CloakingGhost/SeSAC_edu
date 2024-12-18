package org.example.prac1basic;

public class Calculator {
    int num1;
    int num2;

    Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // 덧셈
    int add(){
        return this.num1 + this.num2;
    }

    // 뺄셈
    int minus(){
        return this.num1 - this.num2;
    }

    // 곱셈
    int multiply(){
        return this.num1 * this.num2;
    }
    // 나눗셈
    int divide(){
        return this.num1 / this.num2;
    }

}
