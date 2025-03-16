package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorMultTest extends BaseTest {
    @Tag("operators")
    @ParameterizedTest(name = "{0} => {1} * {2} = {3}")
    @MethodSource("multDoubleParameters")
    public void testDoubleMult(String scenarioName, double a, double b, double expected) {
        assertEquals(expected, calculator.mult(a, b), 0);
    }

    private static Stream<Arguments> multDoubleParameters() {
        return Stream.of(
                Arguments.of("Mult positives", 1.0, 1.0, 1.0),
                Arguments.of("Mult positives", 200.0, 300.0, 60000.0),
                Arguments.of("Mult negative and positive", -1.0, 1.0, -1.0),
                Arguments.of("Mult negatives", -1.0, -1.0, 1.0),
                Arguments.of("Mult with overflow", Double.MAX_VALUE, 2.0, Double.POSITIVE_INFINITY),
                Arguments.of("Mult with underflow", -Double.MAX_VALUE, 2.0, Double.NEGATIVE_INFINITY),
                Arguments.of("Mult zeros", 0.0, 0.0, 0.0),
                Arguments.of("Mult max values", Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY),
                Arguments.of("Mult min values", -Double.MAX_VALUE, -Double.MAX_VALUE, Double.POSITIVE_INFINITY),
                Arguments.of("Mult NaN", Double.NaN, 1.0, Double.NaN),
                Arguments.of("Mult NaN", 1.0, Double.NaN, Double.NaN),
                Arguments.of("Mult NaN", Double.NaN, Double.NaN, Double.NaN)
        );
    }

    @ParameterizedTest(name = "{0} => {1} * {2} = {3}")
    @MethodSource("multLongParameters")
    public void testLongMult(String scenarioName, long a, long b, long expected) {
        assertEquals(expected, calculator.mult(a, b));
    }

    private static Stream<Arguments> multLongParameters() {
        return Stream.of(
                Arguments.of("Mult positives", 1, 1, 1),
                Arguments.of("Mult positives", 200, 300, 60000),
                Arguments.of("Mult negative and positive", -1, 1, -1),
                Arguments.of("Mult negatives", -1, -1, 1),
                Arguments.of("Mult with overflow", Long.MAX_VALUE, 2, -2),
                Arguments.of("Mult with underflow", Long.MIN_VALUE, 2, 0),
                Arguments.of("Mult zeros", 0, 0, 0),
                Arguments.of("Mult max values", Long.MAX_VALUE, Long.MAX_VALUE, 1),
                Arguments.of("Mult min values", Long.MIN_VALUE, Long.MIN_VALUE, 0)
        );
    }
}