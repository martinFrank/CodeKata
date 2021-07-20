package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class SimpleBigDecimalCalculator implements Calculator<BigDecimal> {


    public BigDecimal calculate(Operation<BigDecimal> operation) {
//        ArithmeticFunction function = BasicFunctions.getBasicFunction(operation.operationSymbol, MathContext.DECIMAL64);
        MathFunction<BigDecimal>function = BasicFunctions.getBasicFunction(operation.operationSymbol, MathContext.DECIMAL64);
        BigDecimal result = function.apply(operation.operands);
        System.out.println("result: "+result);
//        return function.apply(operation.operands);
        return result;
    }

    //    @Override
//    public BigDecimal getResult() {
//        ArithmeticFunction function = BasicFunctions.getBasicFunction(operation.operationSymbol, MathContext.DECIMAL64);
//        return function.apply(operation.firstOperand, operation.secondOperand);
//    }
//
//    public void start() {
//        while(calculatorInputReader.hasNext()) {
//            setOperation(calculatorInputReader.getOperation());
//
//        }
//    }

}
