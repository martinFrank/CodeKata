package com.github.martinfrank.perfectrectangle;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/perfect-rectangle/
 */
public class Solution {

    //Assesment: given method from given class - this interface may not be modified
    public boolean isRectangleCover(int[][] input) {
        InputProvider inputProvider = new InputProvider();
        inputProvider.handle(input);
        ArrayDeque<Rectangle> rectangles = inputProvider.getRectangles();
        PerfectRectangleChecker perfectRectangleChecker = new PerfectRectangleChecker(inputProvider.getBounds());
        return perfectRectangleChecker.check(rectangles);
    }


}
