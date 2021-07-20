package com.github.martinfrank.calculator;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://en.wikipedia.org/wiki/Infix_notation
 * Simple - because it can handle only TWO arguments
 */
public class SimpleInfixOperationParser {

    private static final Pattern INPUT_PATTERN =
            Pattern.compile("([+\\-]?\\d+\\.?[\\d]*)\\s*([+\\-*/]{1})\\s*([+\\-]?\\d+\\.?[\\d]*)$");//see https://regex101.com/r/zB7vV3/2
    private static final Pattern EXIT_PATTERN = Pattern.compile("[eE][xX][iI][tT]");

    private Matcher operationMatcher;
    private Matcher exitMatcher;

    public void parseLine(String line) {
        operationMatcher = INPUT_PATTERN.matcher(line);
        exitMatcher = EXIT_PATTERN.matcher(line);
    }

    public boolean hasOperation() {
        return operationMatcher.matches();
    }

    public Operation<BigDecimal> getOperation() {
        String firstArgument = operationMatcher.group(1);
        String symbol = operationMatcher.group(2);
        String secondArgument = operationMatcher.group(3);
        Operand<BigDecimal> firstOp = new Operand<>(new BigDecimal(firstArgument));
        Operand<BigDecimal> secondOp = new Operand<>(new BigDecimal(secondArgument));
        Operands<BigDecimal> operands = new Operands<>(firstOp, secondOp);
        Operation op = new Operation(operands, symbol);
        return op; //new Operation.Builder().first(firstArgument).second(secondArgument).operation(symbol).build();
    }

    public boolean hasNext() {
        return !exitMatcher.matches();
    }
}
