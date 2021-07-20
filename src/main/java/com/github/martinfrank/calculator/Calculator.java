package com.github.martinfrank.calculator;

import java.math.BigDecimal;

public interface Calculator<T> {

    T calculate(Operation<T> operation);


}
