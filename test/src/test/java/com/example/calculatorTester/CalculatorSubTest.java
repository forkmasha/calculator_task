package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorSubTest extends BaseTest {
    @Tag("operators")
    @ParameterizedTest(name = "{0} => {1} - {2} = {3}")
    @MethodSource("subDoubleParameters")
    public void testDoubleSub(String scenarioName, double a, double b, double expected) {
        assertEquals(expected, calculator.sub(a, b), 0);
    }

    private static Stream<Arguments> subDoubleParameters() {
        return Stream.of(
                Arguments.of("Sub positives", 2.0, 1.0, 1.0),
                Arguments.of("Sub positives", 500.0, 300.0, 200.0),
                Arguments.of("Sub negative and positive", -1.0, 1.0, -2.0),
                Arguments.of("Sub negatives", -1.0, -1.0, 0.0),
                Arguments.of("Sub with overflow", Double.MAX_VALUE, -1.0, Double.MAX_VALUE + 1.0),
                Arguments.of("Sub with underflow", -Double.MAX_VALUE, 1.0, -Double.MAX_VALUE - 1.0),
                Arguments.of("Sub zeros", 0.0, 0.0, 0.0),
                Arguments.of("Sub max values", Double.MAX_VALUE, Double.MAX_VALUE, 0.0),
                Arguments.of("Sub min values", -Double.MAX_VALUE, -Double.MAX_VALUE, 0.0),
                Arguments.of("Sub NaN", Double.NaN, 1.0, Double.NaN),
                Arguments.of("Sub NaN", 1.0, Double.NaN, Double.NaN),
                Arguments.of("Sub NaN", Double.NaN, Double.NaN, Double.NaN)
        );
    }

    @ParameterizedTest(name = "{0} => {1} - {2} = {3}")
    @MethodSource("subLongParameters")
    public void testLongSub(String scenarioName, long a, long b, long expected) {
        assertEquals(expected, calculator.sub(a, b));
    }

    private static Stream<Arguments> subLongParameters() {
        return Stream.of(
                Arguments.of("Sub positives", 2, 1, 1),
                Arguments.of("Sub positives", 500, 300, 200),
                Arguments.of("Sub negative and positive", -1, 1, -2),
                Arguments.of("Sub negatives", -1, -1, 0),
                Arguments.of("Sub with overflow", Long.MAX_VALUE, -1, Long.MIN_VALUE),
                Arguments.of("Sub with underflow", Long.MIN_VALUE, 1, Long.MAX_VALUE),
                Arguments.of("Sub zeros", 0, 0, 0),
                Arguments.of("Sub max values", Long.MAX_VALUE, Long.MAX_VALUE, 0),
                Arguments.of("Sub min values", Long.MIN_VALUE, Long.MIN_VALUE, 0)
        );
    }
}