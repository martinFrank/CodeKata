package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.math.MathContext;

public class BasicFunctions {

    private BasicFunctions(){}

    public static ArithmeticFunction getBasicFunction(String operationSymbol, MathContext context) {
        switch (operationSymbol) {
            case "+":
                return new ArithmeticFunction("+", BigDecimal::add);
            case "-":
                return new ArithmeticFunction("-", BigDecimal::subtract);
            case "*":
                return new ArithmeticFunction("*",BigDecimal::multiply );
            case "/":
                return new ArithmeticFunction("/", (first, second) -> first.divide(second, context));
        }
        throw new IllegalArgumentException("unknown function identifier:'" + operationSymbol + "'");
    }
}
