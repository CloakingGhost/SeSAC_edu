package org.example.modifierprac;

public class BankAccount {
    private static final int MIN_LENGTH = 3;
    /*
- 다음 내용을 바탕으로 BankAccount 클래스를 구현하시오.
- 계좌는 잔액과 비밀번호 정보를 가진다
- 잔액과 비밀번호는 외부에서 직접 접근할 수 없다

단, 입금이나 출금시 0원 이하의 금액은 불가능하며,
잔액보다 큰 금액은 출금할 수 없다.*/
    private int balance;
    private String password;

    // 계좌 생성 (비밀번호 설정)
    public BankAccount(String password) {
        this.password = password;
        this.balance = 0;

    }

    // region static method
    // 소통이 기준이 되어야 한다
    // 성능은 그 다음에 개선해도 된다
    public static boolean validateInitialPassword(String password) {
        return validateInitialPassword(password, MIN_LENGTH);
    }

    public static boolean validateInitialPassword(String password, int minLength) {
        return password.length() > minLength;
    }

    // endregion


    // 입금 == setter
    // 입금할 금액 input / balance 증가 / return balance
    public void deposit(int amount) {
        if (!validateAmount(amount)) return;

        balance += amount;
    }

    // 출금 (비밀번호 확인 필요)
    // input: 출금할 금액/ 비밀번호 // 비밀번호 체크 / 잔약을 balance만큼 감소 / return void
    public void withdraw(int amount, String password) {
        if(!validatePassword(password)){
            System.out.println("invalid password");
            return;
        }
        // 음수 제외
        if (!validateAmount(amount)) {
            System.out.println("cannot withdraw");
            return;
        }

        // 잔액보다 큰 금액은 출금 X
        if (amount > balance) {
            return;
        }

        balance -= amount;
    }


    // 잔액 조회 (비밀번호 확인 필요)
    public int getBalance(String password) {
        // 조건문 || try-catch
        if(!validatePassword(password)){
            System.out.println("invalid password");
            return -1;
        }
        System.out.println("balance = " + balance);
        return balance;
    }

    // 비밀번호는 사용자의 입력값과 동일 여부만을 판단한다.
    // getPassword() 없다


    private static boolean validateAmount(int amount) {
        return validateAmount(amount, 0);
    }

    private static boolean validateAmount(int amount, int minAmount) {
        return amount > minAmount;
    }

    private boolean validatePassword(String password) {
        return this.password.equals(password);
    }


}
