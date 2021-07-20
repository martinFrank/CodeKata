package com.github.martinfrank.calculator;

import java.util.function.Function;

public class Operation<T> {

    public final Operands<T> operands;
    public final String operationSymbol;
    public final Function<Operands<T>, MathResult<T>> function;

    public Operation(Operands<T>  operands,String operationSymbol, Function<Operands<T>, MathResult<T>> function){
        this.operands = operands;
        this.operationSymbol = operationSymbol;
        this.function = function;
    }

    public MathResult<T> calculate() {
        return function.apply(operands);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operands=" + operands +
                ", operationSymbol='" + operationSymbol + '\'' +
                ", function=" + function +
                '}';
    }
}
