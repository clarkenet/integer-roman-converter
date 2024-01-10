package org.example.converter;

import org.example.util.ValidatorUtil;

import java.util.Map;

/**
 * Handles the operations needed to convert an integer number to its roman representation.
 */
public class IntegerToRomanConverter {
    private final Map<Integer, String> romanNumsMap;

    public IntegerToRomanConverter() {
        this.romanNumsMap = Map.ofEntries(
                Map.entry(1, "I"),
                Map.entry(5, "V"),
                Map.entry(10, "X"),
                Map.entry(50, "L"),
                Map.entry(100, "C"),
                Map.entry(500, "D"),
                Map.entry(1000, "M")
        );
    }

    /**
     * Gets the roman representation of a single digit integer taking into account its position (factor) when it is part of a
     * bigger number.
     *
     * @param absNum The single digit number which needs to be converted to roman number
     * @param factor The power of 10 factor which represents the position of the absNum in a bigger number
     * @return A String with the roman number representation.
     */
    private String getRomanNum(int absNum, int factor) {
        return switch (absNum) {
            case 1, 2, 3 -> romanNumsMap.get(factor).repeat(absNum);
            case 4 -> romanNumsMap.get(factor) + romanNumsMap.get(factor * 5);
            case 5 -> romanNumsMap.get(factor * 5);
            case 6, 7, 8 -> romanNumsMap.get(factor * 5) + romanNumsMap.get(factor).repeat(absNum - 5);
            case 9 -> romanNumsMap.get(factor) + romanNumsMap.get(factor * 10);
            default -> "";
        };
    }

    /**
     * Generates the roman representation of a string integer.
     *
     * @param stringNumber The string integer value
     * @return A String with the roman number value. It throws an exception if the provided string integer is not valid.
     */
    public String convertToRoman(String stringNumber) {
        // Parse string to int
        int number = ValidatorUtil.validateAndGetInt(stringNumber);
        // Will use this one as the return value
        StringBuilder result = new StringBuilder();

        // Convert each number to its corresponding roman value and add it to the resultant string
        for (int i = 0; i < stringNumber.length(); i++) {
            // Get the power of 10 per iteration (10^0 = 1, 10^1 = 10, 10^2 = 100, 10^3 = 1000)
            int factor = (int) Math.pow(10, i);
            // Get the number at the right position
            int absNum = number % 10;
            // Get the roman number for the calculated single digit number
            String roman = getRomanNum(absNum, factor);
            // Insert the calculated roman number to the overall resultant string
            result.insert(0, roman);
            // Remove the right position number from the original integer
            number /= 10;
        }

        return result.toString();
    }
}
