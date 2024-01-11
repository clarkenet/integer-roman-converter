package org.example.converter;

import org.example.constants.ApplicationConstants;
import org.example.exception.ApplicationException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerToRomanConverterTest {

    private final IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();

    @Test
    void shouldConvertToRomanWhenPassingValidInteger() {
        var numbersToTest = Map.ofEntries(
                Map.entry("524", "DXXIV"),
                Map.entry("689", "DCLXXXIX"),
                Map.entry("1009", "MIX"),
                Map.entry("2498", "MMCDXCVIII"),
                Map.entry("2891", "MMDCCCXCI"),
                Map.entry("3000", "MMM")
        );

        numbersToTest.forEach((intNum, romanNum) -> {
            var result = integerToRomanConverter.convertToRoman(intNum);
            assertEquals(romanNum, result, "Resultant roman number does not match");
        });
    }

    // Just checking that the exception is getting propagated from the validator method
    @Test
    void shouldThrowExceptionWhenPassingInvalidValue() {
        var exception = assertThrows(ApplicationException.class,
                () -> integerToRomanConverter.convertToRoman("Invalid"),
                "Expected exception does not match");

        assertEquals(ApplicationConstants.INVALID_INT_NUMBER_MSG, exception.getMessage(), "Error message does not match");
    }
}