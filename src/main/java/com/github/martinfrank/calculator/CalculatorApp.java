package com.github.martinfrank.calculator;

public class CalculatorApp {

    public static void main(String[] args){
        Calculator calculator = new SimpleCalculator();
        new SimpleInfixConsoleReader(calculator).startReading();
    }
}
