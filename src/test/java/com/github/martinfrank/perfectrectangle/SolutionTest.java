package com.github.martinfrank.perfectrectangle;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void simpeTest() {
        final int[][] input = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        Solution solution = new Solution();
        Assert.assertTrue( solution.isRectangleCover(input) );
    }
}