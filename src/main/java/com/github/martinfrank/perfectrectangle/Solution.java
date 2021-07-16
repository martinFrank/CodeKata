package com.github.martinfrank.perfectrectangle;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/perfect-rectangle/
 */
public class Solution {

    //Assesment: given method within given class from leetcode - this interface may not be modified
    public boolean isRectangleCover(int[][] input) {
        InputProvider inputProvider = new InputProvider();
        inputProvider.handle(input);
        PerfectRectangleChecker perfectRectangleChecker = new PerfectRectangleChecker(inputProvider.getBounds(), inputProvider.rectangles);
        return perfectRectangleChecker.check();
    }


}
