package org.example.modifierprac;

public class BankAccountUtil {
    private static final int MIN_LENGTH = 3;

    public static boolean validateInitialPassword(String password) {
        return validateInitialPassword(password, MIN_LENGTH);
    }

    public static boolean validateInitialPassword(String password, int minLength) {
        return password.length() > minLength;
    }
}
