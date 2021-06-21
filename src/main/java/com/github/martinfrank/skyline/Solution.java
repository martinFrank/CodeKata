package com.github.martinfrank.skyline;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class Solution {

    public static void main(String[] args) {

//        final int[][] input = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//        final int[][] input = {{0,2,3}, {2,5,3}};
//        final int[][] input = {{0,2147483647,2147483647}};
        final int[][] input = {{2,9,10}, {9,12,15}};

        Solution solution = new Solution();
        System.out.println("amount : "+solution.getSkyline(input));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        SkyLineConverter skyLineConverter = new SkyLineConverter();
        SkyLine skyLine = skyLineConverter.convert(buildings);
        Set<Edge> edges = skyLine.getEdges();
        return sortList(edges);
    }

    private List<List<Integer>> sortList(Set<Edge> edges) {
        return edges.stream()
                .sorted(Comparator.comparingInt(edge -> edge.x))
                .map(edge -> List.of(edge.x, edge.height))
                .collect(Collectors.toList());
    }
}
