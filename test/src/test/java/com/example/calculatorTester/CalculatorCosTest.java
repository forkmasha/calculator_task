package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorCosTest extends BaseTest {
    @Tag("trigonometric")
    @ParameterizedTest(name = "{0} => cos[{1}] = {2}")
    @MethodSource("cosParameters")
    public void testCos(String scenarioName, double input, double expected) {
        assertEquals(expected, calculator.cos(input), 0.0001);
    }

    private static Stream<Arguments> cosParameters() {
        return Stream.of(
                Arguments.of("Cos of 0", 0.0, 1.0),
                Arguments.of("Cos of PI/2", Math.PI / 2, 0.0),
                Arguments.of("Cos of PI", Math.PI, -1.0),
                Arguments.of("Cos of 3PI/2", 3 * Math.PI / 2, 0.0),
                Arguments.of("Cos of 2PI", 2 * Math.PI, 1.0),
                Arguments.of("Cos of negative angle", -Math.PI / 2, 0.0),
                Arguments.of("Cos of large angle", 10 * Math.PI, 1.0),
                Arguments.of("Cos of small angle", 1e-10, 1.0)
        );
    }
}
