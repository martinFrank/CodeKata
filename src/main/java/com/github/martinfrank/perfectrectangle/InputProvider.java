package com.github.martinfrank.perfectrectangle;

import java.util.ArrayDeque;
import java.util.Arrays;

public class InputProvider {

    public final ArrayDeque<Rectangle> rectangles = new ArrayDeque<>();
    private int boundsX0 = Integer.MAX_VALUE;
    private int boundsY0 = Integer.MAX_VALUE;
    private int boundsX1 = Integer.MIN_VALUE;
    private int boundsY1 = Integer.MIN_VALUE;


    public void handle(int[][] input) {
        Arrays.stream(input).forEach(this::processInput);
    }

    public void processInput(int[] input){
        rectangles.add(new Rectangle(input));
        updateBounds(input);
    }

    public Rectangle getBounds() {
        return new Rectangle(boundsX0, boundsY0, boundsX1, boundsY1);
    }

    private void updateBounds(int[] input) {
        boundsX0 = Math.min(input[0], boundsX0);
        boundsY0 = Math.min(input[1], boundsY0);
        boundsX1 = Math.max(input[2], boundsX1);
        boundsY1 = Math.max(input[3], boundsY1);
    }

}
