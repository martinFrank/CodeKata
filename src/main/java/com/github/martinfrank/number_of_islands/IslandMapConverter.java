package com.github.martinfrank.number_of_islands;

public class IslandMapConverter {

    public IslandMap convert(char[][] grid) {
        try{
            int mapHeight = grid.length;
            int mapWidth = grid[0].length;

            MapFields mapFields = getMapFields(mapWidth, mapHeight, grid);
            return new IslandMap(mapWidth, mapHeight, mapFields);
        }catch (NullPointerException e){
            throw new IllegalArgumentException ("invalid map format: null");
        }

    }

    private MapFields getMapFields(int mapWidth, int mapHeight, char[][] grid) {
        MapFields mapFields = new MapFields();
        for(int dy = 0; dy < mapHeight; dy++){
            for(int dx = 0; dx < mapWidth; dx++){
                MapFieldType type = getTypeForChar(getChar(grid, dx, dy));
                mapFields.add(new MapField(type, dx, dy));
            }
        }
        return mapFields;
    }

    private char getChar(char[][] grid, int dx, int dy) {
        try{
            return grid[dy][dx];
        }catch (NullPointerException e){
            throw new IllegalArgumentException ("invalid map format (row width mismatch) - x/y=: "+dx+"/"+dy);
        }
    }

    private MapFieldType getTypeForChar(char c) {
        switch (c){
            case '0' : return MapFieldType.WATER;
            case '1' : return MapFieldType.LAND;
            default: throw new IllegalArgumentException ("invalid character for map: "+c);
        }
    }
}
