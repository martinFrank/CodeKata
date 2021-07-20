package com.github.martinfrank.calculator;

public interface OperationParser<T> {

    boolean matches(String operation);

    Operation<T> getOperation();

}
