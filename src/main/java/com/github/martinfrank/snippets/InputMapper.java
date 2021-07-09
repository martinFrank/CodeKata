package com.github.martinfrank.snippets;

public class InputMapper {

    public static final String INPUT = "[[0,0,1,1],[0,0,2,1],[1,0,2,1],[0,2,2,3]]\n";

    public static void main(String[] args) {
        InputMapper inputMapper = new InputMapper(INPUT);

        inputMapper.printMapping();
    }

    private final String input;

    public InputMapper(String input) {
        this.input = input;
    }

    private void printMapping() {
        String mapping = input.replaceAll("\\[", "{").replaceAll("]", "}");
        System.out.println("final int[][] input = "+mapping+";");
    }
}
