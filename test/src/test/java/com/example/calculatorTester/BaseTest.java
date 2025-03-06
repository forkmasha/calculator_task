package com.example.calculatorTester;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import com.epam.tat.module4.Calculator;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {
    protected Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
}
