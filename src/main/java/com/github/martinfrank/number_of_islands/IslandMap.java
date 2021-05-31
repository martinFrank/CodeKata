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
        List<MapField> landFields = mapFields.getLandFieldsWithout(islands);
        while(!landFields.isEmpty()){
            Island island = Island.createFirstFrom(landFields);
            islands.add(island);
            landFields = mapFields.getLandFieldsWithout(islands);
        }
    }

    public List<Island> getIslands() {
        return islands;
    }
}
