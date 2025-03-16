package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorDivTest extends BaseTest {
    @Tag("operators")
    @ParameterizedTest(name = "{0} => {1} / {2} = {3}")
    @MethodSource("divDoubleParameters")
    public void testDoubleDiv(String scenarioName, double a, double b, double expected) {
        assertEquals(expected, calculator.div(a, b), 0);
    }

    private static Stream<Arguments> divDoubleParameters() {
        return Stream.of(
                Arguments.of("Div positives", 4.0, 2.0, 2.0),
                Arguments.of("Div positives", 200.0, 100.0, 2.0),
                Arguments.of("Div negative and positive", -4.0, 2.0, -2.0),
                Arguments.of("Div negatives", -4.0, -2.0, 2.0),
                Arguments.of("Div by zero", 1.0, 0.0, Double.POSITIVE_INFINITY),
                Arguments.of("Div zero by number", 0.0, 1.0, 0.0),
                Arguments.of("Div max values", Double.MAX_VALUE, Double.MAX_VALUE, 1.0),
                Arguments.of("Div min values", -Double.MAX_VALUE, -Double.MAX_VALUE, 1.0),
                Arguments.of("Div NaN", Double.NaN, 1.0, Double.NaN),
                Arguments.of("Div NaN", 1.0, Double.NaN, Double.NaN),
                Arguments.of("Div NaN", Double.NaN, Double.NaN, Double.NaN)
        );
    }

    @ParameterizedTest(name = "{0} => {1} / {2} = {3}")
    @MethodSource("divLongParameters")
    public void testLongDiv(String scenarioName, long a, long b, long expected) {
        assertEquals(expected, calculator.div(a, b));
    }

    private static Stream<Arguments> divLongParameters() {
        return Stream.of(
                Arguments.of("Div positives", 4, 2, 2),
                Arguments.of("Div positives", 200, 100, 2),
                Arguments.of("Div negative and positive", -4, 2, -2),
                Arguments.of("Div negatives", -4, -2, 2),
                Arguments.of("Div zero by number", 0, 1, 0),
                Arguments.of("Div max values", Long.MAX_VALUE, Long.MAX_VALUE, 1),
                Arguments.of("Div min values", Long.MIN_VALUE, Long.MIN_VALUE, 1)
        );
    }

    @Test
    @DisplayName("Dividing by zero should throw NumberFormatException")
    public void divByZeroShouldThrowException() {
        assertThrows(NumberFormatException.class, () -> calculator.div(1, 0));
    }
}
