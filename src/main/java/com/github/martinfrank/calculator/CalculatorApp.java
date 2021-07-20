package com.github.martinfrank.calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorApp {

    public static void main(String[] args){
        final Calculator calculator = new SimpleCalculator();
        final Scanner scanner = new Scanner(System.in);
        final Pattern exitPattern = Pattern.compile("[eE][xX][iI][tT]");
        while (true) {
            String line = scanner.nextLine();
            if(exitPattern.matcher(line).matches()){
                break;
            }
            try {
                MathResult<?> result = calculator.calculate(line);
                System.out.println("result: " + result);
            }catch (Exception e){
                System.out.println("error: " + e);
            }
        }

    }
}
