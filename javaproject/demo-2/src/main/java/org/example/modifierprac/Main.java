package org.example.modifierprac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.getName());
        System.out.println(p.age);
        System.out.println(p.height);
        p.study();
        p.walk();
//        p.run();// private method
        p.exercise();

        BankAccount myAccount = null;
        String password = null;
        // 올바르게 입력 할 때까지
        while (myAccount == null) {
            // 사용자 입력
            // Scanner 배웠다 치고
            Scanner sc = new Scanner(System.in);
            password = sc.next();
            boolean isValid = BankAccount.validateInitialPassword(password);
//            boolean isValid = BankAccountUtil.validateInitialPassword(password);
            if (!isValid) {
                System.out.println("Passwords must be at least 4 characters long");
            } else {
                myAccount = new BankAccount(password);
            }

        }
        myAccount.deposit(100000);
        myAccount.getBalance(password);
        myAccount.withdraw(10000, password);
        myAccount.getBalance(password);


        // 에러 동작 확인
        myAccount.getBalance("12123");
    }
}
