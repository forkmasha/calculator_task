package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorPowTest extends BaseTest {

    @Tag("operators")
    @ParameterizedTest(name = "{0} => {1} ^ {2} = {3}")
    @MethodSource("powDoubleParameters")
    public void testDoublePow(String scenarioName, double base, double exponent, double expected) {
        assertEquals(expected, calculator.pow(base, exponent), 0);
    }

    private static Stream<Arguments> powDoubleParameters() {
        return Stream.of(
                Arguments.of("Positive base and exponent", 2.0, 3.0, 8.0),
                Arguments.of("Negative base and positive exponent", -2.0, 3.0, -8.0),
                Arguments.of("Positive base and negative exponent", 2.0, -3.0, 0.125),
                Arguments.of("Negative base and negative exponent", -2.0, -3.0, -0.125),
                Arguments.of("Base zero and positive exponent", 0.0, 3.0, 0.0),
                Arguments.of("Base zero and zero exponent", 0.0, 0.0, 1.0),
                Arguments.of("Positive base and zero exponent", 2.0, 0.0, 1.0),
                Arguments.of("Negative base and zero exponent", -2.0, 0.0, 1.0),
                Arguments.of("Base one and any exponent", 1.0, 1000.0, 1.0),
                Arguments.of("Base negative one and even exponent", -1.0, 2.0, 1.0),
                Arguments.of("Base negative one and odd exponent", -1.0, 3.0, -1.0),
                Arguments.of("Base NaN", Double.NaN, 2.0, Double.NaN),
                Arguments.of("Exponent NaN", 2.0, Double.NaN, Double.NaN),
                Arguments.of("Base and exponent NaN", Double.NaN, Double.NaN, Double.NaN)
        );
    }
}