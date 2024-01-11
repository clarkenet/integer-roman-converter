package org.example.converter;

import org.example.constants.ApplicationConstants;
import org.example.exception.ApplicationException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerConverterTest {

    private final RomanToIntegerConverter converter = new RomanToIntegerConverter();

    @Test
    void shouldConvertToIntegerWhenPassingValidRomanString() {
        var numbersToTest = Map.ofEntries(
                Map.entry(" i ", 1),
                Map.entry("dxxiv", 524),
                Map.entry("  DCLXXXIX  ", 689),
                Map.entry("cmxx", 920),
                Map.entry("MIX", 1009),
                Map.entry("MMCDXCVIII", 2498),
                Map.entry("MMDCCCXCI", 2891),
                Map.entry("mmm", 3000)
        );

        numbersToTest.forEach((romanStr, expectedInt) -> {
            int result = converter.convertToInteger(romanStr);

            assertEquals(expectedInt, result, "Result does not match the expected value");
        });
    }

    // Just checking that the exception is getting propagated from the validator method
    @Test
    void shouldThrowExceptionWhenPassingInvalidValue() {
        var exception = assertThrows(ApplicationException.class,
                () -> converter.convertToInteger("Invalid"),
                "Expected exception does not match");

        assertEquals(ApplicationConstants.INVALID_ROMAN_NUMBER_MSG, exception.getMessage(), "Error message does not match");
    }
}