package org.example.converter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanConverterTest {

    private final IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();

    @Test
    void shouldConvertToRomanWhenValidInteger() {
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
}