package com.github.martinfrank.calculator;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTrigonometricOperationParser  implements OperationParser<Double> {

    private static final Pattern INPUT_PATTERN =
            Pattern.compile("^([cC][oO][sS]|[sS][iI][nN]|[tT][aA][nN])\\s*([+-]?\\d+\\.?\\d*)$");

    private Matcher operationMatcher;

    @Override
    public boolean matches(String input) {
        operationMatcher = INPUT_PATTERN.matcher(input);
        return operationMatcher.matches();
    }

    @Override
    public Operation<Double> getOperation() {
        String symbol = operationMatcher.group(1);
        String operand = operationMatcher.group(2).toLowerCase(Locale.ROOT);
        Operands<Double> operands = new Operands<>(Double.parseDouble(operand));
        MathFunction<Double> function = TrigonometricFunction.getBasicFunction(symbol);
        return new Operation<>(operands, symbol, function);
    }
}
