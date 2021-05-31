package com.github.martinfrank.number_of_islands;

import java.util.*;
import java.util.stream.Collectors;

public class MapFields {

    private final Set<MapField> mapFields = new HashSet<>();

    public MapFields() {
    }

    public void add(MapField mapField) {
        mapFields.add(mapField);
    }

    //visible for testing
    MapField getField(final int xpos, final int ypos) {
        return mapFields.stream().
                filter(mf -> mf.xpos == xpos && mf.ypos == ypos).
                findAny().orElse(null);
    }

    public List<MapField> getLandFieldsWithout(Collection<Island> islands) {
        final List<MapField> islandFields = new ArrayList<>();
        islands.forEach(i -> islandFields.addAll(i.getFields()));
        return mapFields.stream().
                filter(f -> f.type == MapFieldType.LAND).
                filter(f -> !islandFields.contains(f)).
                collect(Collectors.toList());
    }

}
