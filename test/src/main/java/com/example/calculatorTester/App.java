package com.example.calculatorTester;

import com.epam.tat.module4.Calculator;

public class App 
{
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
        System.out.println( calculator.sum( 1, 2 ) );
    }
}
