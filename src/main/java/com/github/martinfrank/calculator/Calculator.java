package com.github.martinfrank.calculator;

import java.math.BigDecimal;

public interface Calculator {

    void setOperation(Operation operation);

    BigDecimal getResult();

}
