package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.security.cert.CertPathBuilder;

public class Operation {

    public final  BigDecimal firstOperand;
    public final BigDecimal secondOperand;
    public final ArithmeticFunction operation;

    public Operation(BigDecimal firstOperand, BigDecimal secondOperand, ArithmeticFunction operation){
        this.operation = operation;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public BigDecimal getResult() {
        return operation.apply(firstOperand, secondOperand);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "first=" + firstOperand +
                ", second=" + secondOperand +
                ", function=" + operation +
                '}';
    }


    public static class Builder {

        private BigDecimal first;
        private BigDecimal second;
        private ArithmeticFunction operation;

        public Builder first(String first) {
            this.first = new BigDecimal(first);
            return this;
        }

        public Builder second(String second) {
            this.second = new BigDecimal(second);
            return this;
        }

        public Builder operation(String operation) {
            this.operation = BasicFunctions.getBasicFunction(operation);
            return this;
        }

        public Operation build() {
            if(first == null){
                throw new IllegalArgumentException("first operand may not be null");
            }
            if(second == null){
                throw new IllegalArgumentException("second operand may not be null");
            }
            if(operation == null){
                throw new IllegalArgumentException("operation may not be null");
            }
            return new Operation(first, second, operation);
        }
    }
}
