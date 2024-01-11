package org.example.util;

import org.example.constants.ApplicationConstants;
import org.example.exception.ApplicationException;

public class ValidatorUtil {
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
