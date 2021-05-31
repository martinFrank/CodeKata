package com.github.martinfrank.number_of_islands;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IslandMapConverterTest {

    @Test
    public void testGoodCase(){

        final char[][] mapGrid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        IslandMapConverter islandMapConverter = new IslandMapConverter();
        IslandMap map = islandMapConverter.convert(mapGrid);

        assertEquals(5, map.mapWidth);
        assertEquals(4, map.mapHeight);
        assertEquals(MapFieldType.LAND, map.getField(0,0).type);
        assertEquals(MapFieldType.WATER, map.getField(4,0).type);
        assertNull(map.getField(5,0));
    }


}