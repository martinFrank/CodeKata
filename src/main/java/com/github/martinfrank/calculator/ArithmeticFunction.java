package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class ArithmeticFunction implements BiFunction<BigDecimal, BigDecimal, BigDecimal> {

    public final String symbol;
    private BiFunction<BigDecimal, BigDecimal, BigDecimal> function;

    public ArithmeticFunction(String symbol, BiFunction<BigDecimal, BigDecimal, BigDecimal> function){
        this.symbol = symbol;
        this.function = function;
    }

    @Override
    public BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand) {
        return function.apply(firstOperand, secondOperand);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
