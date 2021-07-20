package com.github.martinfrank.calculator;

import java.math.BigDecimal;

public class CalculatorApp {

    public static void main(String[] args){
        Calculator<BigDecimal> calculator = new SimpleBigDecimalCalculator();
//        CalculatorInputReader inputReader = new SimpleInfixConsoleReader(calculator);
//        calculator.setInputReader(inputReader);
//        calculator.start();
        new SimpleInfixConsoleReader(calculator).startReading();
    }
}
