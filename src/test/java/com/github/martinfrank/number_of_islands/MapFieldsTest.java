package com.github.martinfrank.number_of_islands;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MapFieldsTest {

    public final char[][] mapGrid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '1'}
    };

    @Test
    public void testGoodCase(){
        IslandMapConverter islandMapConverter = new IslandMapConverter();
        IslandMap map = islandMapConverter.convert(mapGrid1);

        //given
        MapFields mapFields = map.mapFields;

        //when
        List<Island> islands = new ArrayList<>();

        //then
        assertEquals(10, mapFields.getLandFieldsWithout(islands).size());

        //when
        Island island = new Island(map.getField(4,3));
        island.extend(Collections.emptyList());
        islands.add(island);

        //then
        assertEquals(9, mapFields.getLandFieldsWithout(islands).size());
    }

    @Test
    public void testIsAdjected(){
        MapField center = new MapField(MapFieldType.LAND, 1,1);

        MapField north = new MapField(MapFieldType.LAND, 1,0);
        MapField east = new MapField(MapFieldType.LAND, 2,1);
        MapField south = new MapField(MapFieldType.LAND, 1,2);
        MapField west = new MapField(MapFieldType.LAND, 0,1);

        assertTrue(center.isAdjectedTo(north));
        assertTrue(center.isAdjectedTo(east));
        assertTrue(center.isAdjectedTo(south));
        assertTrue(center.isAdjectedTo(west));

        MapField northWest = new MapField(MapFieldType.LAND, 0,0);
        MapField northEast = new MapField(MapFieldType.LAND, 2,0);
        MapField southEast = new MapField(MapFieldType.LAND, 2,2);
        MapField southWest = new MapField(MapFieldType.LAND, 0,2);

        assertFalse(center.isAdjectedTo(northWest));
        assertFalse(center.isAdjectedTo(northEast));
        assertFalse(center.isAdjectedTo(southEast));
        assertFalse(center.isAdjectedTo(southWest));

        MapField anotherCenter = new MapField(MapFieldType.LAND, 1,1);

        assertFalse(center.isAdjectedTo(anotherCenter));
    }

}