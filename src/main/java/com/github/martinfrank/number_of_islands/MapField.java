package com.github.martinfrank.number_of_islands;

import java.util.Objects;

public class MapField {

    public final int xpos;
    public final int ypos;
    public final MapFieldType type;

    public MapField(MapFieldType type, int dx, int dy) {
        this.type = type;
        this.xpos = dx;
        this.ypos = dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapField mapField = (MapField) o;
        return xpos == mapField.xpos && ypos == mapField.ypos && type == mapField.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xpos, ypos, type);
    }

    public boolean isConnectedTo(MapField candidate) {
        if (candidate.xpos == xpos && candidate.ypos == ypos - 1) { //NORTH
            return true;
        }
        if (candidate.xpos == xpos && candidate.ypos == ypos + 1) { //SOUTH
            return true;
        }
        if (candidate.xpos == xpos - 1 && candidate.ypos == ypos) { //WEST
            return true;
        }
        //not simplified for better reading of directions
        if (candidate.xpos == xpos + 1 && candidate.ypos == ypos) { //EAST
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MapField{" +
                "xpos=" + xpos +
                ", ypos=" + ypos +
                ", type=" + type +
                '}';
    }
}
