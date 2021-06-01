package com.github.martinfrank.number_of_islands;

import java.util.*;
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
        final Set<MapField> firstFields = new HashSet<>();
        final Set<MapField> secondFields = new HashSet<>();
        firstFields.add(startField);
        do {
            Set<MapField> connectedFields = new HashSet<>();
            for (MapField openField : firstFields) {
                Set<MapField> connectedOnes = getConnectedFields(openField, candidates);
                connectedFields.addAll(connectedOnes);
                candidates.removeAll(connectedFields);
            }
            secondFields.addAll(firstFields);
            firstFields.clear();
            firstFields.addAll(connectedFields);
            if(connectedFields.isEmpty()){
                secondFields.addAll(connectedFields);
                break;
            }
        }while(true);
        mapFields.addAll(secondFields);
    }

    private Set<MapField> getConnectedFields(MapField center, List<MapField> candidates) {
        return candidates.stream().
                filter(center::isConnectedTo).
                collect(Collectors.toSet());
    }
}
