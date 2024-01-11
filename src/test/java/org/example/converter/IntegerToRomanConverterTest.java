package org.example.converter;

import org.example.constants.ApplicationConstants;
import org.example.exception.ApplicationException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanConverterTest {

    private final IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();
    private final String NOT_EXPECTED_ERROR_MSG_DSC = "Error message does not match";
    private final String NOT_EXPECTED_EXCEPTION_DSC = "Expected exception does not match";

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

    @Test
    void shouldThrowExceptionWhenPassingIntegerOutOfSupportedRange() {
        var numbersToTest = List.of("-1", "0", "3001");

        numbersToTest.forEach(number -> {
            var exception = assertThrows(ApplicationException.class,
                    () -> integerToRomanConverter.convertToRoman(number),
                    NOT_EXPECTED_EXCEPTION_DSC);

            assertEquals(ApplicationConstants.OUT_OF_RANGE_MSG, exception.getMessage(), NOT_EXPECTED_ERROR_MSG_DSC);
        });
    }

    @Test
    void shouldThrowExceptionWhenPassingInvalidInteger() {
        var exception = assertThrows(ApplicationException.class,
                () -> integerToRomanConverter.convertToRoman("Invalid"),
                NOT_EXPECTED_EXCEPTION_DSC);

        assertEquals(ApplicationConstants.INVALID_INT_NUMBER_MSG, exception.getMessage(), NOT_EXPECTED_ERROR_MSG_DSC);
    }
}