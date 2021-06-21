package com.github.martinfrank.skyline;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildingConverter {

    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 1;
    private static final int HEIGHT_INDEX = 2;

    public List<Building> convert(int[][] raw) {
        return Arrays.stream(raw)
                .map(arr -> new Building(arr[FROM_INDEX],
                        arr[TO_INDEX] - arr[FROM_INDEX],
                        arr[HEIGHT_INDEX]))
                .collect(Collectors.toList());
    }
}
