package com.github.martinfrank.number_of_islands;

import java.util.ArrayList;
import java.util.List;

public class Island {

    private final List<MapField> openFields;
    private final List<MapField> closedFields;

    public Island(MapField startField) {
        openFields = new ArrayList<>();
        closedFields = new ArrayList<>();
        openFields.add(startField);
    }


    public List<MapField> getFields() {
        return closedFields;
    }

    public void extend(List<MapField> candidates) {

        List<MapField> addedFields = new ArrayList<>();
        do {
            for (MapField openField : openFields) {
                for (MapField candidate : candidates) {
                    if (openField.isAdjectedTo(candidate)) {
                        addedFields.add(candidate);
                    }
                }
                candidates.removeAll(addedFields);
                closedFields.addAll(openFields);
                openFields.clear();
                openFields.addAll(addedFields);
                addedFields.clear();
                break;
            }
        }while(!openFields.isEmpty());
    }
}
