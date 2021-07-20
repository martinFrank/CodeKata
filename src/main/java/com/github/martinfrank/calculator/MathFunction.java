package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.math.BigInteger;

@FunctionalInterface
public interface MathFunction<T> {

    T apply(Operands<T> o);
}
