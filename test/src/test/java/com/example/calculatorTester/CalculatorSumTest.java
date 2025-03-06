package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorSumTest extends BaseTest {

    @ParameterizedTest(name = "{0} => {1} + {2} = {3}")
    @MethodSource("sumDoubleParameters")
    public void testDoubleSum(String scenarioName, double a, double b, double expected) {
        assertEquals(expected, calculator.sum(a, b), 0);
    }

    private static Stream<Arguments> sumDoubleParameters() {
        return Stream.of(
                Arguments.of("Sum positives", 1.0, 1.0, 2.0),
                Arguments.of("Sum positives", 200.0, 300.0, 500.0),
                Arguments.of("Sum negative and positive", -1.0, 1.0, 0.0),
                Arguments.of("Sum negatives", -1.0, -1.0, -2.0),
                Arguments.of("Sum with overflow", Double.MAX_VALUE, 1.0, Double.MAX_VALUE + 1.0),
                Arguments.of("Sum with underflow", -Double.MAX_VALUE, -1.0, -Double.MAX_VALUE - 1.0),
                Arguments.of("Sum zeros", 0.0, 0.0, 0.0),
                Arguments.of("Sum max values", Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY),
                Arguments.of("Sum min values", -Double.MAX_VALUE, -Double.MAX_VALUE, Double.NEGATIVE_INFINITY),
                Arguments.of("Sum NaN", Double.NaN, 1.0, Double.NaN),
                Arguments.of("Sum NaN", 1.0, Double.NaN, Double.NaN),
                Arguments.of("Sum NaN", Double.NaN, Double.NaN, Double.NaN)
        );
    }

    @ParameterizedTest(name = "{0} => {1} + {2} = {3}")
    @MethodSource("sumLongParameters")
    public void testLongSum(String scenarioName, long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b), 0);
    }

    private static Stream<Arguments> sumLongParameters() {
        return Stream.of(
                Arguments.of("Sum positives", 1, 1, 2),
                Arguments.of("Sum positives", 200, 300, 500),
                Arguments.of("Sum negative and positive", -1, 1, 0),
                Arguments.of("Sum negatives", -1, -1, -2),
                Arguments.of("Sum with overflow", Long.MAX_VALUE, 1, Long.MIN_VALUE),
                Arguments.of("Sum with underflow", Long.MIN_VALUE, -1, Long.MAX_VALUE),
                Arguments.of("Sum zeros", 0, 0, 0),
                Arguments.of("Sum max values", Long.MAX_VALUE, Long.MAX_VALUE, -2),
                Arguments.of("Sum min values", Long.MIN_VALUE, Long.MIN_VALUE, 0)
        );
    }
}