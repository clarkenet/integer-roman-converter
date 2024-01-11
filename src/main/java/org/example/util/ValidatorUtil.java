package org.example.util;

import org.example.constants.ApplicationConstants;
import org.example.exception.ApplicationException;

import java.util.Objects;

/**
 * Utilities for input validation
 */
public class ValidatorUtil {

    /**
     * Validates that the received string is a valid integer in the range of 1 - 3000.
     *
     * @param stringNumber The string under validation
     * @return The validated integer. Throws an ApplicationException if the string does not comply with the criteria
     */
    public static int validateAndGetInt(String stringNumber) {
        try {
            var number = Integer.parseInt(Objects.requireNonNullElse(stringNumber, "").trim());
            if (number <= 0 || number > 3000) throw new ApplicationException(ApplicationConstants.OUT_OF_RANGE_MSG);
            return number;
        } catch (NumberFormatException nfe) {
            throw new ApplicationException(ApplicationConstants.INVALID_INT_NUMBER_MSG);
        }
    }

    /**
     * Validates that the received string is not empty and is a valid roman number.
     *
     * @param stringRoman The string under validation
     * @return A valid and formatted roman number. Throws an ApplicationException if the string does not comply with the
     * criteria
     */
    public static String validateAndGetRoman(String stringRoman) {
        if (stringRoman == null || stringRoman.isBlank()) {
            throw new ApplicationException(ApplicationConstants.EMPTY_ROMAN_NUMBER_MSG);
        }

        String romanNum = stringRoman.trim().toUpperCase();
        if (!romanNum.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            throw new ApplicationException(ApplicationConstants.INVALID_ROMAN_NUMBER_MSG);
        }

        return romanNum;
    }
}
