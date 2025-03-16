package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorIsNegativeTest extends BaseTest {
    @Tag("other")
    @ParameterizedTest(name = "{0} => {1} is negative = {2}")
    @MethodSource("isNegativeParameters")
    public void testIsNegative(String scenarioName, long a, boolean expected) {
        assertEquals(expected, calculator.isNegative(a));
    }

    private static Stream<Arguments> isNegativeParameters() {
        return Stream.of(
                Arguments.of("Negative number", -1, true),
                Arguments.of("Positive number", 1, false),
                Arguments.of("Zero", 0, false),
                Arguments.of("Long.MIN_VALUE", Long.MIN_VALUE, true),
                Arguments.of("Long.MAX_VALUE", Long.MAX_VALUE, false)
        );
    }
}
