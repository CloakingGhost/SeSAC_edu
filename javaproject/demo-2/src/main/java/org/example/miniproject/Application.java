package org.example.miniproject;

import org.example.miniproject.clazz.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 자판기 세팅
        Product<ProductType> 칠성사이다 = new Product<>("칠성사이다", 1000, ProductType.BEVERAGE);
        칠성사이다.setRemain(10);

        Product<ProductType> 코카콜라 = new Product<>("코카콜라", 2000, ProductType.BEVERAGE);
        코카콜라.setRemain(20);

        Product<ProductType> 제로콜라 = new Product<>("제로콜라", 4000, ProductType.BEVERAGE);
        제로콜라.setRemain(30);

        Product<ProductType> 후라보노 = new Product<>("후라보노", 8000, ProductType.ETC);
        후라보노.setRemain(40);

        Product<ProductType> 포켓미니티슈 = new Product<>("포켓미니티슈", 16000, ProductType.ETC);
        포켓미니티슈.setRemain(50);

        VendingMachine bvm = new BeverageVendingMachine();
//        bvm.setPayment(cash);
        bvm.updateProduct(칠성사이다, 코카콜라, 제로콜라, 후라보노, 포켓미니티슈);


//        System.out.println();
//        Payment cash = new Cash(100_000);
//        NormalUser normalUser1 = new NormalUser();
//        normalUser1.setPayment(cash);
//        normalUser1.inputPayment(bvm);
//
//        boolean 결제결과 = bvm.pay("칠성사이다");
//        if (!결제결과) System.out.println("이름을 다시 입력해주세요");
//        bvm.displayProductAll();


        boolean mainFlag = true;
        Scanner sc = new Scanner(System.in);
        // 시나리오 실행
        while (mainFlag) {
            // 사람이 옴
            System.out.println("어서오세요");
            System.out.println("모드 번호를 선택해 주세요");
            // 관리자 모드 선택
            // 사용자 모드 선택
            System.out.println("1: 사용자 모드, 2: 관리자 모드, 3: 종료");
            String mode = sc.next();
            // 사용자 모드
            if (isNumber(mode)) {
                if (mode.equals("1")) {


                    // 품절 제품 표기
                    bvm.displayProductAll();
                    // 구매여부 확인
                    System.out.println("1: 제품 구매, 2: 종료");
                    String ans1 = sc.next();
                    if (isNumber((ans1))) {
                        if (ans1.equals("2")) {
                            System.out.println("이용해 주셔서 감사합니다");
                            break; // 프로그램 종료}
                        } else if (!ans1.equals("1")) {
                            System.out.println("다시 입력해주세요");
                        }
                    }
                    NormalUser normalUser = new NormalUser();
                    System.out.println("결제수단 번호를 선택해 주세요");
                    System.out.println("1: 현금, 2: 체크카드(구현중), 3: 신용카드(구현중)");
                    Payment payment = null;
                    String paymentMode = sc.next();
                    switch (paymentMode) {
                        case "1" -> {
                            System.out.println("1000 이상의 금액을 입력하세요");
                            String amount = sc.next();
                            if (isNumber(amount) && Integer.parseInt(amount) >= 1000) {
                                payment = new Cash(Integer.parseInt(amount));
                            } else {
                                System.out.println("숫자만 입력해주세요");
                            }
                        }
                    }
                    normalUser.setPayment(payment);
                    normalUser.inputPayment(bvm);
                    bvm.displayAvailablePurchase();

                    System.out.println("구매 희망하는 상품 이름을 입력 해주세요");
                    String productName = sc.next();
                    bvm.pay(productName);
                }
            } else if (mode.equals("2")) {
                // 관리자 모드
                Manager manager = new Manager();

                // 재고 확인
                manager.showProducts(bvm);
                // 상품 가격 설정
                    // 이름 입력
                    // 변경 가격 입력

                // 재고 추가
//                bvm.updateProduct();
                // 매출 확인
                manager.showRevenue(bvm);
            } else if (mode.equals("3")) {
                    break;
            } else {
                System.out.println("번호를 확인해주세요");
            }


        }
        sc.close();

    }

    public static boolean isNumber(String word) {
        return word.matches("\\d+");
    }
}
