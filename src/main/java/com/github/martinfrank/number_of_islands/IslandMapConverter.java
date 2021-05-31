package com.github.martinfrank.number_of_islands;

public class IslandMapConverter {

    public IslandMap convert(char[][] grid) {
        int mapWidth = grid[0].length;
        int mapHeight = grid.length;

        MapFields mapFields = getMapFields(mapWidth, mapHeight, grid);
        return new IslandMap(mapWidth, mapHeight, mapFields);
    }

    private MapFields getMapFields(int mapWidth, int mapHeight, char[][] grid) {
        MapFields mapFields = new MapFields();
        for(int dy = 0; dy < mapHeight; dy++){
            for(int dx = 0; dx < mapWidth; dx++){
                MapFieldType type = getTypeForChar(grid[dy][dx]);
                mapFields.add(new MapField(type, dx, dy));
            }
        }
        return mapFields;
    }

    private MapFieldType getTypeForChar(char c) {
        switch (c){
            case '0' : return MapFieldType.WATER;
            case '1' : return MapFieldType.LAND;
            default: throw new IllegalArgumentException ("invalid character for map: "+c);
        }
    }
}
