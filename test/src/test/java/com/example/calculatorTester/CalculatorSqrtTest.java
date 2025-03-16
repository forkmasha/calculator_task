package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorSqrtTest extends BaseTest {
    @Tag("operators")
    @ParameterizedTest(name = "{0} => sqrt[{1}] = {2}")
    @MethodSource("sqrtParameters")
    public void testSqrt(String scenarioName, double input, double expected) {
        assertEquals(expected, calculator.sqrt(input), 0);
    }

    private static Stream<Arguments> sqrtParameters() {
        return Stream.of(
                Arguments.of("Sqrt positive", 4.0, 2.0),
                Arguments.of("Sqrt zero", 0.0, 0.0),
                Arguments.of("Sqrt one", 1.0, 1.0),
                Arguments.of("Sqrt positive", 9.0, 3.0),
                Arguments.of("Sqrt positive", 16.0, 4.0),
                Arguments.of("Sqrt NaN", Double.NaN, Double.NaN),
                Arguments.of("Sqrt negative", -1.0, 1.0),
                Arguments.of("Sqrt infinity", Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
        );
    }
}
