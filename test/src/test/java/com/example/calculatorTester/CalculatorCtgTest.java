package com.example.calculatorTester;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorCtgTest extends BaseTest {

    @ParameterizedTest(name = "{0} => ctg[{1}] = {2}")
    @MethodSource("ctgParameters")
    public void testCtg(String scenarioName, double input, double expected) {
        assertEquals(expected, calculator.ctg(input), 0.0001);
    }

    private static Stream<Arguments> ctgParameters() {
        return Stream.of(
                Arguments.of("Ctg of 45 degrees", Math.PI / 4, 1.0),
                Arguments.of("Ctg of 90 degrees", Math.PI / 2, 0.0),
                Arguments.of("Ctg of 0 degrees", 0.0, Double.POSITIVE_INFINITY),
                Arguments.of("Ctg of 135 degrees", 3 * Math.PI / 4, -1.0),
                Arguments.of("Ctg of -45 degrees", -Math.PI / 4, -1.0),
                Arguments.of("Ctg of -90 degrees", -Math.PI / 2, 0.0),
                Arguments.of("Ctg of positive infinity", Double.POSITIVE_INFINITY, Double.NaN),
                Arguments.of("Ctg of negative infinity", Double.NEGATIVE_INFINITY, Double.NaN),
                Arguments.of("Ctg of NaN", Double.NaN, Double.NaN)
        );
    }
}
