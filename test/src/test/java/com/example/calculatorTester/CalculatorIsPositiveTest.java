package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorIsPositiveTest extends BaseTest {

    @ParameterizedTest(name = "{0} => {1} is positive = {2}")
    @MethodSource("isPositiveParameters")
    public void testIsPositive(String scenarioName, long a, boolean expected) {
        assertEquals(expected, calculator.isPositive(a));
    }

    private static Stream<Arguments> isPositiveParameters() {
        return Stream.of(
                Arguments.of("Negative number", -1, false),
                Arguments.of("Positive number", 1, true),
                Arguments.of("Zero", 0, false),
                Arguments.of("Long.MIN_VALUE", Long.MIN_VALUE, false),
                Arguments.of("Long.MAX_VALUE", Long.MAX_VALUE, true)
        );
    }
}