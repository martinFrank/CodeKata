package com.github.martinfrank.calculator;

import java.math.BigDecimal;

public class SimpleCalculator implements Calculator{

    private Operation operation;

    @Override
    public void setOperation(Operation operation) {
        this.operation = operation;
        System.out.println("Operation: "+ operation +", Result:"+ getResult());
    }

    @Override
    public BigDecimal getResult() {
        return operation.getResult();
    }

}
