package com.github.martinfrank.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://en.wikipedia.org/wiki/Infix_notation
 * Simple - because it can handle only TWO arguments
 */
public class SimpleInfixOperationParser {

    private static final Pattern INPUT_PATTERN =
            Pattern.compile("([\\+\\-]?\\d+\\.?[\\d]*)\\s*([\\+\\-\\*\\/]{1})\\s*([\\+\\-]?\\d+\\.?[\\d]*)$");//see https://regex101.com/r/zB7vV3/2
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

    public Operation getOperation() {
        String firstArgument = operationMatcher.group(1);
        String operation = operationMatcher.group(2);
        String secondArgument = operationMatcher.group(3);
        return new Operation.Builder().first(firstArgument).second(secondArgument).operation(operation).build();
    }

    public boolean hasNext() {
        return !exitMatcher.matches();
    }
}
