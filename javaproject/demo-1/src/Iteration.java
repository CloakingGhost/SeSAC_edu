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
            menu = getAnInt(sc, menu);

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
                    int cash = 0;
                    cash = getAnInt(sc, cash);
                    if (cash == 0) {
                        System.out.println("0원은 출금할 수 없습니다.");
                    } else if (cash > account) {
                        System.out.println("잔액이 부족합니다");
                        System.out.println("확인 후 다시 이용해주세요");
                    } else {
                        System.out.printf("%d원 출금합니다.\n", cash);
                        account -= cash;
                    }
                    System.out.println("잔액확인을 원하시면 1번을");
                    System.out.println("다른 업무를 원하시면 2번을 입력해주세요\n");
                    menu = sc.nextInt();
                    if (menu == 1) {
                        System.out.printf("남은 잔액은 %d원 입니다\n", account);
                    }
                }
                case 3 -> {
                    System.out.printf("고객님 계좌의 잔액은 %d원 입니다\n", account);
                }

            }
        }
        sc.close();
    }

    private static int getAnInt(Scanner sc, int num) {
        boolean isNum = false;
        while (!isNum) {
            System.out.println("출금할 금액을 입력해 주세요");
            String input = sc.next(); // 문자열로 입력 받기

            // 입력값이 숫자인지 확인
            if (input.matches("\\d+")) { // 숫자만 포함된 경우
                num = Integer.parseInt(input);
                isNum = true; // 숫자가 맞으면 반복 종료
            } else {
                System.out.println("숫자만 입력해주세요.");
            }
        }
        return num;
    }
}
