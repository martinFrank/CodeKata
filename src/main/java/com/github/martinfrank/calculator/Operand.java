package com.github.martinfrank.calculator;

public class Operand<T> {

    private final T t;

    public Operand(T t){
        this.t = t;
    }

    public T getType(){
        return t;
    }
}
