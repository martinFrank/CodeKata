package com.github.martinfrank.number_of_islands;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandMapTest {

    public final char[][] mapGrid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
    };

    public final char[][] mapGrid2 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '1'}
    };

    @Test
    public void test(){
        IslandMapConverter mapConverter = new IslandMapConverter();
        IslandMap islandMap1 =  mapConverter.convert(mapGrid1);
        assertEquals(1, islandMap1.getIslands().size());

        IslandMap islandMap2 =  mapConverter.convert(mapGrid2);
        assertEquals(2, islandMap2.getIslands().size());
    }

}