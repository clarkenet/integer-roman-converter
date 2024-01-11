package org.example.util;

import org.example.constants.ApplicationConstants;
import org.example.exception.ApplicationException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorUtilTest {

    private final String NOT_EXPECTED_EXCEPTION_DSC = "Expected exception does not match";
    private final String NOT_EXPECTED_ERROR_MSG_DSC = "Error message does not match";

    @Test
    void shouldReturnIntegerWhenPassingValidIntegerString() {
        var stringsToTest = Map.ofEntries(
                Map.entry("1", 1),
                Map.entry("  299  ", 299),
                Map.entry("589", 589),
                Map.entry("3000", 3000)
        );

        stringsToTest.forEach((stringNum, expectedNum) -> {
            var parsedNum = ValidatorUtil.validateAndGetInt(stringNum);

            assertEquals(expectedNum, parsedNum, "Parsed number does not match");
        });
    }

    @Test
    void shouldThrowExceptionWhenPassingIntegerOutOfSupportedRange() {
        var numbersToTest = List.of("-1", "0", "3001");

        numbersToTest.forEach(number -> {
            var exception = assertThrows(ApplicationException.class,
                    () -> ValidatorUtil.validateAndGetInt(number),
                    NOT_EXPECTED_EXCEPTION_DSC);

            assertEquals(ApplicationConstants.OUT_OF_RANGE_MSG, exception.getMessage(), NOT_EXPECTED_ERROR_MSG_DSC);
        });
    }

    @Test
    void shouldThrowExceptionWhenPassingInvalidInteger() {
        var valuesToTest = Arrays.asList("Invalid", null);

        valuesToTest.forEach(value -> {
            var exception = assertThrows(ApplicationException.class,
                    () -> ValidatorUtil.validateAndGetInt(value),
                    NOT_EXPECTED_EXCEPTION_DSC);

            assertEquals(ApplicationConstants.INVALID_INT_NUMBER_MSG, exception.getMessage(), NOT_EXPECTED_ERROR_MSG_DSC);
        });
    }

    @Test
    void shouldReturnFormattedRomanNumberWhenPassingValidRomanString() {
        var stringsToTest = Map.ofEntries(
                Map.entry("i", "I"),
                Map.entry("  CCXCIX  ", "CCXCIX"),
                Map.entry("DLXXXIX", "DLXXXIX"),
                Map.entry("mmm", "MMM")
        );

        stringsToTest.forEach((strInput, expected) -> {
            var formattedStr = ValidatorUtil.validateAndGetRoman(strInput);

            assertEquals(expected, formattedStr, "Formatted string does not match");
        });
    }

    @Test
    void shouldThrowExceptionWhenPassingNullOrEmptyString() {
        var stringsToTest = Arrays.asList(null, "", "  ");

        stringsToTest.forEach(str -> {
            var exception = assertThrows(ApplicationException.class,
                    () -> ValidatorUtil.validateAndGetRoman(str),
                    NOT_EXPECTED_EXCEPTION_DSC);

            assertEquals(ApplicationConstants.EMPTY_ROMAN_NUMBER_MSG, exception.getMessage(), NOT_EXPECTED_ERROR_MSG_DSC);
        });
    }

    @Test
    void shouldThrowExceptionWhenPassingInvalidString() {
        var stringsTotTest = List.of("iiii", "cccc", "MMMM", "IXIX", "IC", "VM", "A", "abc", "XD");

        stringsTotTest.forEach(str -> {
            var exception = assertThrows(ApplicationException.class,
                    () -> ValidatorUtil.validateAndGetRoman(str),
                    NOT_EXPECTED_EXCEPTION_DSC);

            assertEquals(ApplicationConstants.INVALID_ROMAN_NUMBER_MSG, exception.getMessage(), NOT_EXPECTED_ERROR_MSG_DSC);
        });
    }
}