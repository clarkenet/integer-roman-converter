package org.example.util;

import org.example.constants.ApplicationConstants;
import org.example.exception.ApplicationException;

/**
 * Utilities for input validation
 */
public class ValidatorUtil {

    /**
     * Validates that the received string is a valid integer in the range of 1 - 3000.
     * @param stringNumber The string under validation
     * @return The validated integer. Throws an ApplicationException if the string does not comply with the criteria
     */
    public static int validateAndGetInt(String stringNumber) {
        try {
            var number = Integer.parseInt(stringNumber);
            if (number <= 0 || number > 3000) throw new ApplicationException(ApplicationConstants.OUT_OF_RANGE_MSG);
            return number;
        } catch (NumberFormatException nfe) {
            throw new ApplicationException(ApplicationConstants.INVALID_INT_NUMBER_MSG);
        }
    }
}
