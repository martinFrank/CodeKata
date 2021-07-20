package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.security.cert.CertPathBuilder;

public class Operation<T> {

//    public final BigDecimal firstOperand;
//    public final BigDecimal secondOperand;

    public final Operands<T> operands;
    public final String operationSymbol;
//    public final ArithmeticFunction operation;//FIXME here you would place a operation type and let the calculator do the magic

////    public Operation(BigDecimal firstOperand, BigDecimal secondOperand, ArithmeticFunction operation){
//        public Operation(BigDecimal firstOperand, BigDecimal secondOperand,String operationSymbol){
//        this.firstOperand = firstOperand;
//        this.secondOperand = secondOperand;
////        this.operation = operation;
//            this.operationSymbol = operationSymbol;
//    }

    //    public Operation(BigDecimal firstOperand, BigDecimal secondOperand, ArithmeticFunction operation){
    public Operation(Operands<T> operands,String operationSymbol){
        this.operands = operands;
//        this.firstOperand = firstOperand;
//        this.secondOperand = secondOperand;
//        this.operation = operation;
        this.operationSymbol = operationSymbol;
    }

//    public BigDecimal getResult() {
//        return operation.apply(firstOperand, secondOperand);
//    }

//    @Override
//    public String toString() {
//        return "Operation{" +
//                "first=" + firstOperand +
//                ", second=" + secondOperand +
////                ", function=" + operation +
//                ", operationSymbol=" + operationSymbol +
//                '}';
//    }


//    public static class Builder<T> {
//
//        private Operand<T> first;
//        private Operand<T> second;
////        private ArithmeticFunction operation;
//        private String operationSymbol;
//
//        public Builder first(String first) {
//            this.first = new BigDecimal(first);
//            return this;
//        }
//
//        public Builder second(String second) {
//            this.second = new BigDecimal(second);
//            return this;
//        }
//
////        public Builder operation(String operation) {
////            this.operation = BasicFunctions.getBasicFunction(operation);
////            return this;
////        }
//
//        public Builder operation(String operationSymbol) {
//            this.operationSymbol = operationSymbol;
//            return this;
//        }
//
//        public Operation build() {
//            if(first == null){
//                throw new IllegalArgumentException("first operand may not be null");
//            }
//            if(second == null){
//                throw new IllegalArgumentException("second operand may not be null");
//            }
////            if(operation == null){
////                throw new IllegalArgumentException("operation may not be null");
////            }
//            if(operationSymbol == null){
//                throw new IllegalArgumentException("operation may not be null");
//            }
////            return new Operation(first, second, operation);
//            return new Operation(first, second, operationSymbol);
//        }
//    }
}
