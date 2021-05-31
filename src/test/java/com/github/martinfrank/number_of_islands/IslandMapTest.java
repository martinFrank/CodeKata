package com.github.martinfrank.number_of_islands;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandMapTest {



    @Test
    public void test(){
        IslandMapConverter mapConverter = new IslandMapConverter();

        final char[][] mapGrid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        IslandMap islandMap1 =  mapConverter.convert(mapGrid1);

        assertEquals(1, islandMap1.getIslands().size());

        final char[][] mapGrid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        IslandMap islandMap2 =  mapConverter.convert(mapGrid2);
        assertEquals(2, islandMap2.getIslands().size());

        final char[][] mapGrid3 = {
                {'1', '1', '1', '1', '1', '1','1'}
        };
        IslandMap islandMap3 =  mapConverter.convert(mapGrid3);
        assertEquals(1, islandMap3.getIslands().size());
    }

}