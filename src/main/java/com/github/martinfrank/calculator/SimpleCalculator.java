package com.github.martinfrank.calculator;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCalculator implements Calculator {

    private final List<OperationParser<?>> operationParsers = new ArrayList<>();

    public SimpleCalculator(){
        operationParsers.add(new SimpleInfixArithmeticOperationParser(MathContext.DECIMAL64));
        operationParsers.add(new SimpleTrigonometricOperationParser());
    }

    @Override
    public MathResult<?> calculate(String input) {
        Optional<OperationParser<?>> parser = operationParsers.stream().filter(ip -> ip.matches(input)).findAny();
        if(parser.isPresent()){
            System.out.println("calculating "+parser.get().getOperation());
            return parser.get().getOperation().calculate();
        }else {
            throw new IllegalArgumentException("no valid parser for input '"+input+"' found");
        }
    }


}
