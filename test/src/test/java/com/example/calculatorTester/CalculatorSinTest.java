package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorSinTest extends BaseTest {
    @Tag("trigonometric")
    @ParameterizedTest(name = "{0} => sin[{1}] = {2}")
    @MethodSource("sinParameters")
    public void testSin(String scenarioName, double input, double expected) {
        assertEquals(expected, calculator.sin(input), 0.0001);
    }

    private static Stream<Arguments> sinParameters() {
        return Stream.of(
                Arguments.of("Sin of 0", 0.0, 0.0),
                Arguments.of("Sin of PI/2", Math.PI / 2, 1.0),
                Arguments.of("Sin of PI", Math.PI, 0.0),
                Arguments.of("Sin of 3PI/2", 3 * Math.PI / 2, -1.0),
                Arguments.of("Sin of 2PI", 2 * Math.PI, 0.0),
                Arguments.of("Sin of -PI/2", -Math.PI / 2, -1.0),
                Arguments.of("Sin of -PI", -Math.PI, 0.0),
                Arguments.of("Sin of -3PI/2", -3 * Math.PI / 2, 1.0),
                Arguments.of("Sin of -2PI", -2 * Math.PI, 0.0)
        );
    }
}
