package org.example;

class Rectangle{

    // 각이 몇개니? 에 사용 됨
    static int angleCount = 4;

    int width;
    int height;

    /*
     * this 객체 자신
     *
     * 오른쪽: 입력,값 width
     * 왼쪽: 객체의 width 속성
     * */
    Rectangle(){
        this(10, 10);}
    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    /*
     * class에 있는 함수를 메소드라 부른다
     *
     *
     * */
    int calculateArea(){
        return width * height;
    }

}

/*
 설계도 이지만 비슷한 특징들은 모은것 군집화 됨
 군집으로서 공통으로서 가지고 있어야 하는 것 : 스태틱 변수

 클래스는 현실세계의 개념 또는 필요로 하는 어떤 개념에 대한 변수와 기능의 모음

 클래스는 단순히 변수와 기능의 모음으로도 볼 수 있음
*
* */