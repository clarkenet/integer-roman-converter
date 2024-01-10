package org.example.util;

public class ValidatorUtil {
    public static int validateAndGetInt(String stringNumber) {
        var number = Integer.parseInt(stringNumber);
        if (number <= 0 || number > 3000) throw new RuntimeException("Please provide a number between 1 and 3000");
        return number;
    }
}
