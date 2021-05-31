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
        Island island = Island.createFirstFrom(mapFields.getLandFieldsWithout(islands));
        islands.add(island);

        //then
        assertEquals(1, mapFields.getLandFieldsWithout(islands).size());
    }

    @Test
    public void testIsConnected(){
        MapField center = new MapField(MapFieldType.LAND, 1,1);

        MapField north = new MapField(MapFieldType.LAND, 1,0);
        MapField east = new MapField(MapFieldType.LAND, 2,1);
        MapField south = new MapField(MapFieldType.LAND, 1,2);
        MapField west = new MapField(MapFieldType.LAND, 0,1);

        assertTrue(center.isConnectedTo(north));
        assertTrue(center.isConnectedTo(east));
        assertTrue(center.isConnectedTo(south));
        assertTrue(center.isConnectedTo(west));

        MapField northWest = new MapField(MapFieldType.LAND, 0,0);
        MapField northEast = new MapField(MapFieldType.LAND, 2,0);
        MapField southEast = new MapField(MapFieldType.LAND, 2,2);
        MapField southWest = new MapField(MapFieldType.LAND, 0,2);

        assertFalse(center.isConnectedTo(northWest));
        assertFalse(center.isConnectedTo(northEast));
        assertFalse(center.isConnectedTo(southEast));
        assertFalse(center.isConnectedTo(southWest));

        MapField anotherCenter = new MapField(MapFieldType.LAND, 1,1);

        assertFalse(center.isConnectedTo(anotherCenter));
    }

}