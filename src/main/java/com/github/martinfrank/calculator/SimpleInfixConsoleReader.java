package com.github.martinfrank.calculator;

import java.util.Scanner;

/**
 * https://en.wikipedia.org/wiki/Infix_notation
 * Simple - because it can handle only TWO arguments
 */
public class SimpleInfixConsoleReader {

    private final Calculator calculator;

    public SimpleInfixConsoleReader(Calculator calculator){
        this.calculator = calculator;
    }

    public void startReading() {
        Scanner scanner = new Scanner(System.in);
        SimpleInfixOperationParser parser = new SimpleInfixOperationParser();
        do {
            String line = scanner.nextLine();
            parser.parseLine(line);
            if(parser.hasOperation()) {
                calculator.setOperation(parser.getOperation());
            }else{
                System.out.println("input '"+line+"' is not a valid infix operation!");
            }
        }
        while(parser.hasNext());
    }

}
