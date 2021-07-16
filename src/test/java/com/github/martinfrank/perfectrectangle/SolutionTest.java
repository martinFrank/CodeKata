package com.github.martinfrank.perfectrectangle;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    final static int[][] VALID_DATA = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
    final static int[][] INVAILD_DATA = {{0,0,1,1},{0,0,2,1},{1,0,2,1},{0,2,2,3}};

    @Test
    public void testValidInput() {
        Solution solution = new Solution();
        Assert.assertTrue( solution.isRectangleCover(VALID_DATA) );
    }

    @Test
    public void testInvalidInput() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isRectangleCover(INVAILD_DATA) );
    }

    //more test after more data is provided
}