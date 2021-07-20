package com.github.martinfrank.calculator;

public class MathResult<T> {

    private T t;

    public MathResult(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "MathResult{" +
                "t=" + t +
                '}';
    }
}
