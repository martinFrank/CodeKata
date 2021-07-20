package com.github.martinfrank.calculator;

import java.util.Locale;
import java.util.function.Function;

public class TrigonometricFunction extends MathFunction<Double>{

    private final Function<Double, Double> function;

    public TrigonometricFunction(String symbol, Function<Double, Double> function){
        super(symbol);
        this.function = function;
    }

    @Override
    public MathResult<Double> apply(Operands<Double> operands) {
        return new MathResult<>(function.apply(operands.get()));
    }

    public static TrigonometricFunction getBasicFunction(String operationSymbol) {
        return new TrigonometricFunction(operationSymbol, getFunction(operationSymbol));
    }

    private static Function<Double, Double> getFunction(String operationSymbol) {
        switch (operationSymbol) {
            case "sin":
                return Math::sin;
            case "cos":
                return Math::cos;
            case "tan":
                return Math::tan;
        }
        throw new IllegalArgumentException("unknown function identifier:'" + operationSymbol + "'");
    }
}
