package com.github.martinfrank.calculator;

public class Operands<T> {

    private final Operand<T> first;
    private final Operand<T> second;


    public Operands (Operand<T> single){
        this(single, null);
    }

    public Operands (Operand<T> first, Operand<T> second){
        if(first == null){
            throw new IllegalArgumentException("first (single) operand must be set");
        }
        this.first = first;
        this.second = second;
    }

    public Operand<T> get(){
        return getFirst();
    }

    public Operand<T> getFirst(){
        return first;
    }

    public Operand<T> getSecond(){
        if(second == null){
            throw new IllegalArgumentException("second Operand does not exist");
        }
        return second;
    }
}
