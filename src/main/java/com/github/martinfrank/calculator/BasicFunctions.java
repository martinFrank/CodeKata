package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.math.MathContext;

public class BasicFunctions {

    private static final ArithmeticFunction ADD_FUNCTION = new ArithmeticFunction("+", BigDecimal::add);
    private static final ArithmeticFunction SUBTRACT_FUNCTION = new ArithmeticFunction("-", BigDecimal::subtract);
    private static final ArithmeticFunction MULTIPLY_FUNCTION = new ArithmeticFunction("*",BigDecimal::multiply );
    private static final ArithmeticFunction DIVIDE_FUNCTION =
            new ArithmeticFunction("/", (first, second) -> first.divide(second, MathContext.DECIMAL64));

    public static ArithmeticFunction getBasicFunction(String identifier) {
        switch (identifier) {
            case "+":
                return ADD_FUNCTION;
            case "-":
                return SUBTRACT_FUNCTION;
            case "*":
                return MULTIPLY_FUNCTION;
            case "/":
                return DIVIDE_FUNCTION;
        }
        throw new IllegalArgumentException("unknown function identifier:'" + identifier + "'");
    }
}
