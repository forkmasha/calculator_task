package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTgTest extends BaseTest {

   @ParameterizedTest(name = "{0} => tg[{1}] = {2}")
    @MethodSource("tgParameters")
    public void testTg(String scenarioName, double input, double expected) {
        assertEquals(expected, calculator.tg(input), 0.0001);
    }

    private static Stream<Arguments> tgParameters() {
        return Stream.of(
                Arguments.of("Tg of 0", 0.0, 0.0),
                Arguments.of("Tg of PI/4", Math.PI / 4, 1.0),
                Arguments.of("Tg of -PI/4", -Math.PI / 4, -1.0),
                Arguments.of("Tg of PI", Math.PI, 0.0),
                Arguments.of("Tg of Positive Infinity", Double.POSITIVE_INFINITY, Double.NaN),
                Arguments.of("Tg of Negative Infinity", Double.NEGATIVE_INFINITY, Double.NaN),
                Arguments.of("Tg of NaN", Double.NaN, Double.NaN)
        );
    }
}
