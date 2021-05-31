package com.github.martinfrank.number_of_islands;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class Solution {

    public static void main(String[] args) {

//        final char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '1'}
//        };

        final char[][] grid = {
                {'1', '1', '1', '1', '1', '1','1'}
        };
        Solution solution = new Solution();
        System.out.println("amount : "+solution.numIsland(grid));
    }

    public int numIsland(char[][] grid) {
        IslandMapConverter converter = new IslandMapConverter();
        IslandMap islandMap =  converter.convert(grid);
        return islandMap.getIslands().size();
    }
}
