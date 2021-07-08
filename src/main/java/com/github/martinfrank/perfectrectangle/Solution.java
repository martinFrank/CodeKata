package com.github.martinfrank.perfectrectangle;


import java.util.ArrayDeque;
import java.util.List;

/**
 * https://leetcode.com/problems/perfect-rectangle/
 */
public class Solution {

    //Assesment: given method from given class - this interface may not be modified
    public boolean isRectangleCover(int[][] input) {
        InputReader inputReader = new InputReader();
        inputReader.readInput(input);
        ArrayDeque<Rectangle> rectangles = inputReader.getRectangles();
        CornerCountChecker cornerCountChecker = new CornerCountChecker(inputReader.getBounds());
        return cornerCountChecker.check(rectangles);
    }


}
