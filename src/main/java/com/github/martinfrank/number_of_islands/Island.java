package com.github.martinfrank.number_of_islands;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Island {

    private final List<MapField> mapFields = new ArrayList<>();

    public static Island createFirstFrom(List<MapField> openFields) {
        Island island = new Island();
        island.extendFirstFrom(openFields);
        return island;
    }

    public List<MapField> getFields() {
        return mapFields;
    }

    private void extendFirstFrom(List<MapField> candidates) {
        MapField startField = candidates.remove(0);//that's the first
        final List<MapField> openFields = new ArrayList<>();
        openFields.add(startField);
        do {
            for (MapField openField : openFields) {
                List<MapField> connectedFields = getConnectedFields(openField, candidates);
                candidates.removeAll(connectedFields);
                mapFields.addAll(openFields);
                openFields.clear();
                openFields.addAll(connectedFields);
                break;
            }
        }while(!openFields.isEmpty());
    }

    private List<MapField> getConnectedFields(MapField openField, List<MapField> candidates) {
        return candidates.stream().
                filter(openField::isConnectedTo).
                collect(Collectors.toList());
    }
}
