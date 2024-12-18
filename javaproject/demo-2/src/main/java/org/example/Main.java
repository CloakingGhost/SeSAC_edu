package org.example;

/*같은 폴더에 있는 클래스는 임포트 안해도 됨*/
public class Main {
    public static void main(String[] args) {
        // 클래스는 모르겠고 일단 사각형에 대해 만들어 보자
//        int[] size = {
//                width : 100,
//                height: 200,
//        }

        int width = 100;
        int height = 200;
        int area = width * height;

        int width2 = 300;
        int height2 = 400;
        int area2 = width * height;

        /*
        * 사각형은 가로 세로가 있어야해
        * 그러면 사각형이라고 해줄게
        * area가 있는데 가로와 세로를 곱한 값이야
        * 이것을 넓이라고 할게
        *
        * 여러 사각형이 있다면
        * 변수와 area를 구하는 기능이 중복되네?
        * 반복을 할 수 있는 class라는 것을 만들어 보자
        *
        *
        *
        * 정보들을 하나로 묶어서 볼 수 있다.
        * 속성과 메소드를 하나의 공간이 묶은것
        *
        * 클래스 변수 메서드 있는데
        * 하나의 기능 하는 독자설 설계도
        * 예시를 가지고 만들어 사용할거야
        * 책의 공통 특징(이름 ,sibn) 반납 등등
        * Book 클래스를 만들어서
        * 속성과 기능을 묶은 것이다
        * */
        int value = 3;

        int[] array = new int[6];
        // int[] -> Rectangle
        Rectangle rect1 = new Rectangle();
        // 100: width, 200: height 라고 입력에 대한 약속
        Rectangle rect2 = new Rectangle(100, 200);
        // JS 처럼 속성을 꺼내보자
        System.out.println(rect2.width);
        System.out.println("rect2.calculateArea() = " + rect2.calculateArea());

        Circle circle = new Circle(4);
        System.out.println(circle.radius);
        System.out.println(circle.calculateArea());


        System.out.println();
        Rectangle rectangle = new Rectangle(10, 30);
        System.out.println("rectangle.angleCount = " + rectangle.angleCount);
        System.out.println("Rectangle.angleCount = " + Rectangle.angleCount);



    }
}
/*
* 사각형의 공통된 특징을 모아서 관리한다
* width, height calculateArea()를 가지고 있는다
*
*
* 객체들 간에 상호작용으로 세상을 설명한다
*
* 강사님 (person) 나(person)
* 연필을 사용한다
*
* 추상적인 개념도 가능
* 요청을 받아서 응답을 준다 axios
* baseurl을 통해 데이터를 받아서 json을 준다.
* */

/*
* 설계도를 사용하여 만들수 있다
* */


/*
* 추상화
* 필요한 것만 모은다
* 교육생
* 이름
* 기술 스택
* 잔고(필요없음)
* 주소(필요없음)
*
* 엔티티 관계 지향적 설계
*
*
*
* */

/*
 * DTO
 * 데이터 정제하는 클래스
 *
 * db에서 100개 속성이 있을 때
 * 3개만 담고 싶을 때
 *
 * */

/*
* class의 3가지 공간
* 변수
* 생성자
* 메서드
*
*
* class는 그 자체로 타입이다
* 내가만드는 타입
* */


/*
* class로 만든 것이 객체, 인스턴스
*
* class로 만든어진 객체로 무엇인가를 한다
*
* 인스턴스: 어떠한 클래스로 부터 만들어진 자식이다라는 것을 설명하기 위한 대표명사(대명사)
* 객체 : 인스턴스와 동일한 의미지만 인스턴스가 특정되는 것
*
* 어린이(클래스) 철수(객체)
* 객체인 철수는 어린이 클래스의 인스턴스
*
*
* */

