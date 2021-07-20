package com.github.martinfrank.calculator;

import java.util.function.Function;

public abstract class MathFunction<T> implements Function<Operands<T>, MathResult<T>> {

    public final String symbol;

    public MathFunction(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    @Override
    public abstract MathResult<T> apply(Operands<T> o);

}
