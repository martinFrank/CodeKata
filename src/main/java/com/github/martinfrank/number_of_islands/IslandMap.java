package com.github.martinfrank.number_of_islands;

import java.util.ArrayList;
import java.util.List;

public class IslandMap {

    public final int mapWidth;
    public final int mapHeight;
    public final MapFields mapFields;
    private final List<Island> islands;

    public IslandMap(int mapWidth, int mapHeight, MapFields mapFields) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.mapFields = mapFields;
        islands = new ArrayList<>();
        calculateIslands();
    }

    public MapField getField(int xpos, int ypos) {
        return mapFields.getField(xpos,ypos);
    }

    private void calculateIslands(){
        List<MapField> openFields = mapFields.getLandFieldsWithout(islands);
        while(!openFields.isEmpty()){
            MapField any = openFields.remove(0);
            Island island = new Island(any);
            island.extend(openFields);
            islands.add(island);
            openFields = mapFields.getLandFieldsWithout(islands);
        }
    }

    public List<Island> getIslands() {
        return islands;
    }
}
