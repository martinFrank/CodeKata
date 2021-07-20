package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://en.wikipedia.org/wiki/Infix_notation
 * Simple - because it can handle only TWO arguments and only the operations * - / *
 */
public class SimpleInfixArithmeticOperationParser implements OperationParser<BigDecimal> {

    private static final Pattern INPUT_PATTERN =
            Pattern.compile("([+\\-]?\\d+\\.?[\\d]*)\\s*([+\\-*/])\\s*([+\\-]?\\d+\\.?[\\d]*)$");//see https://regex101.com/r/zB7vV3/2

    private Matcher operationMatcher;
    private final MathContext mathContext;

    public SimpleInfixArithmeticOperationParser(MathContext mathContext) {
        this.mathContext = mathContext;
    }

    @Override
    public boolean matches(String input) {
        operationMatcher = INPUT_PATTERN.matcher(input);
        return operationMatcher.matches();
    }

    public Operation<BigDecimal> getOperation() {
        String firstArgument = operationMatcher.group(1);
        String symbol = operationMatcher.group(2);
        String secondArgument = operationMatcher.group(3);
        Operands<BigDecimal> operands = new Operands<>(new BigDecimal(firstArgument), new BigDecimal(secondArgument));
        MathFunction<BigDecimal> function = ArithmeticFunction.getBasicFunction(symbol, mathContext);
        return new Operation<>(operands, symbol, function);
    }

}
