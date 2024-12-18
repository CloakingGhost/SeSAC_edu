package org.example.prac1basic;

public class Prac1 {
    public static void main(String[] args) {
        Car car = new Car("Avante");
        car.increase(10);
        car.increase(10);
        car.increase(10);
        car.decrease(10);
        System.out.println(car);

        MP3Player sony = new MP3Player("sony");
        sony.changeState();
        sony.increaseVolume();
        System.out.println(sony);

        Calculator calc = new Calculator(12, 4);
        System.out.println("calc.add() = " + calc.add());
        System.out.println("calc.minus() = " + calc.minus());
        System.out.println("calc.multiply() = " + calc.multiply());
        System.out.println("calc.divide() = " + calc.divide());

        Calculator2 calc2 = new Calculator2();
        Calculator2 calc3 = new Calculator2();
        System.out.println("calc2.add(10, 4) = " + calc2.add(10, 4));
        System.out.println("calc2.minus(30, 12) = " + calc2.minus(30, 12));

        System.out.println("Calculator2.staticAdd(14, 25) = " + Calculator2.staticAdd(14, 25));
//        System.out.println("Calculator2.add(14, 25)" + Calculator2.add(14, 25)); // add 인스턴스 메서드

        Dog poppy = new Dog("puddle", "poppy");
        Dog poppyJunior = new Dog("puddle", "poppyJunior");
        System.out.println(Dog.count);
    }
}
