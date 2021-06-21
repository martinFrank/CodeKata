package com.github.martinfrank.skyline;

import java.util.List;

public class SkyLineConverter {
    public SkyLine convert(int[][] raw) {
        BuildingConverter buildingConverter = new BuildingConverter();
        List<Building> buildings = buildingConverter.convert(raw);
        return new SkyLine(buildings);
    }
}
