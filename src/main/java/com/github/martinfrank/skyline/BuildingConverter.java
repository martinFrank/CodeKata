package com.github.martinfrank.skyline;

import java.util.ArrayList;
import java.util.List;

public class BuildingConverter {

    private static final int X_FROM_INDEX = 0;
    private static final int X_TO_INDEX = 1;
    private static final int HEIGHT_INDEX = 2;

    public List<Building> convert(int[][] raw) {
        List<Building> buildings = new ArrayList<>();
        for (int[] buildingRaw: raw){
            int x = buildingRaw[X_FROM_INDEX];
            int width = buildingRaw[X_TO_INDEX] - buildingRaw[X_FROM_INDEX];
            int height = buildingRaw[HEIGHT_INDEX];
            buildings.add(new Building(x,width,height));
        }
        return buildings;
    }
}
