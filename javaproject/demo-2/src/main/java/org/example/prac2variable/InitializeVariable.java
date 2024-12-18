package org.example.prac2variable;

public class InitializeVariable {
    public static void main(String[] args) {
        V1 v1 = new V1();
        System.out.println("v1.value = " + v1.value);

        V2 v2 = new V2();
        System.out.println("v2.value = " + v2.value);

        V3 v3 = new V3();
        System.out.println("v3.value = " + v3.value);
    }
}

class V1 {
    static int staticValue = 30;

    int value = 10;
    String word = "Text";
}

class V2 {
    int value;
    String word;

    public V2() {
        this(10, "Text");
    }

    public V2(int value, String word) {
        this.value = value;
        this.word = word;
    }
}

class V3 {
    static int staticValue;
    int value;
    String word;

    // 스태틱 변수가 로직에 의해 결정될 때
    static {
        if (true) {
            staticValue = 30;
        } else {
            staticValue = 50;
        }
    }

    // 인스턴스 변수가 로직에 의해 결정될 때
    {
        if (true) {
            this.value = 10;
        } else {
            this.value = 12;
        }
        this.word = "Text";
    }


}