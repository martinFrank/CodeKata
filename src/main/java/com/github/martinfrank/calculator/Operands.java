package com.github.martinfrank.calculator;

public class Operands<T> {

    private final T first;
    private final T second;

    public Operands(T single) {
        this(single, null);
    }

    public Operands(T first, T second) {
        if (first == null) {
            throw new IllegalArgumentException("first (single) operand must be set");
        }
        this.first = first;
        this.second = second;
    }

    public T get() {
        return getFirst();
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        if (second == null) {
            throw new IllegalArgumentException("second Operand does not exist");
        }
        return second;
    }

    @Override
    public String toString() {
        if (second != null) {
            return "Operands{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        } else {
            return "Operands{" + first + '}';
        }
    }
}
