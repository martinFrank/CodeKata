package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.function.BiFunction;

public class ArithmeticFunction extends MathFunction<BigDecimal> {

    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> function;

    public ArithmeticFunction(String symbol, BiFunction<BigDecimal, BigDecimal, BigDecimal> function){
        super(symbol);
        this.function = function;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public MathResult<BigDecimal> apply(Operands<BigDecimal> o) {
        return new MathResult<>(function.apply(o.getFirst(), o.getSecond()));
    }

    public static ArithmeticFunction getBasicFunction(String operationSymbol, MathContext context) {
        return new ArithmeticFunction(operationSymbol, getFunction(operationSymbol, context));
    }

    private static BiFunction<BigDecimal, BigDecimal, BigDecimal> getFunction(String operationSymbol, MathContext context) {
        switch (operationSymbol) {
            case "+":
                return BigDecimal::add;
            case "-":
                return BigDecimal::subtract;
            case "*":
                return BigDecimal::multiply;
            case "/":
                return (first, second) -> first.divide(second, context);
        }
        throw new IllegalArgumentException("unknown function identifier:'" + operationSymbol + "'");
    }
}
