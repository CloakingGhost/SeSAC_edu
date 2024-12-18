import java.util.InputMismatchException;
import java.util.Scanner;

public class Iteration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int account = 0;
        System.out.println("어서오세요 고객님");
        boolean flag = true;
        while (flag) {
            System.out.println("메뉴를 선택해 주세요");
            System.out.println("1: 입금, 2: 출금, 3: 잔액확인, 0: 종료");
            int menu = 0;
            try {
                menu = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 입력이 아닙니다. 프로그램을 종료합니다.");
                System.out.println("error: type");
                menu = 0;
            }
            switch (menu) {
                case 0 -> {
                    flag = false;
                    System.out.println("이용해주셔서 감사합니다.");
                }
                case 1 -> {
                    System.out.println("입금할 금액을 입력해 주세요");
                    try {

                        int cash = sc.nextInt();
                        account += cash;
                    } catch (InputMismatchException e) {
                        System.out.println("21억 이하의 금액을 입력해주세요");
                        System.out.println("금액 확인 후 이용 바랍니다.");
                        System.out.println("error: length\n");
                    }
                }
                case 2 -> {
                    System.out.println("출금할 금액을 입력해 주세요");
                    int cash = sc.nextInt();
                    if (cash > account) {
                        System.out.println("잔액이 부족합니다");
                        System.out.println("확인 후 다시 이용해주세요");
                    } else {
                        System.out.printf("%d원 출금합니다.\n", cash);
                        account -= cash;
                        System.out.println("잔액확인을 원하시면 1번을");
                        System.out.println("다른 업무를 원하시면 2번을 입력해주세요\n");
                        menu = sc.nextInt();
                        if (menu == 1) {
                            System.out.printf("남은 잔액은 %d원 입니다\n", account);
                        }
                    }
                }
                case 3 -> {
                    System.out.printf("고객님 계좌의 잔약은 %d원 입니다\n", account);
                }
                default -> {
                    System.out.println("잘못된 입력입니다 메뉴를 확인해주세요");
                    System.out.println("error: number\n");
                }
            }
        }
    }
}
