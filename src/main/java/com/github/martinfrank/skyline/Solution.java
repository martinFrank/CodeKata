package com.github.martinfrank.skyline;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class Solution {

    public static void main(String[] args) {

//        final int[][] input = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//        final int[][] input = {{0,2,3}, {2,5,3}};
        final int[][] input = {{0,2147483647,2147483647}};

        Solution solution = new Solution();
        System.out.println("amount : "+solution.getSkyline(input));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        SkyLineConverter skyLineConverter = new SkyLineConverter();
        SkyLine skyLine = skyLineConverter.convert(buildings);
        List<Edge> edges = skyLine.getEdges();
        List<List<Integer>> converted = new ArrayList<>();
        for(Edge edge: edges){
            List<Integer> intList = new ArrayList<>();
            intList.add(edge.x);
            intList.add(edge.height);
            converted.add(intList);
        }
        return converted;
    }
}
