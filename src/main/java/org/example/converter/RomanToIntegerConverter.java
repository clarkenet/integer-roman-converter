package org.example.converter;

import org.example.util.ValidatorUtil;

import java.util.Map;

/**
 * Handles the operations needed to convert a roman number to its integer representation.
 */
public class RomanToIntegerConverter {

    private final Map<Character, Integer> integerMap;

    public RomanToIntegerConverter() {
        this.integerMap = Map.ofEntries(
                Map.entry('I', 1),
                Map.entry('V', 5),
                Map.entry('X', 10),
                Map.entry('L', 50),
                Map.entry('C', 100),
                Map.entry('D', 500),
                Map.entry('M', 1000)
        );
    }

    /**
     * Gets the integer value of a given roman string number.
     *
     * @param strRoman The roman string number to be converted to integer
     * @return The integer value of strRoman. Throws ApplicationException if strRoman is invalid
     */
    public int convertToInteger(String strRoman) {
        String romanNum = ValidatorUtil.validateAndGetRoman(strRoman);
        int result = 0;

        for (int i = 0; i < romanNum.length(); i++) {
            // Get the integer value of the single roman character at the current position
            int value = integerMap.get(romanNum.charAt(i));
            // Calculate the next index
            int nextIndex = i + 1;
            // Check if the next integer value is greater than the current one
            // If it is greater, the current value should decrement result, otherwise it should increment it
            if (nextIndex < romanNum.length() && value < integerMap.get(romanNum.charAt(nextIndex))) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }
}
