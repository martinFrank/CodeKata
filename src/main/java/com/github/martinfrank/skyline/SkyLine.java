package com.github.martinfrank.skyline;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkyLine {

    private final int[] skyline;
    private final int width;
    private final int height;
    private List<Edge> edges = new ArrayList<>();

    public SkyLine(List<Building> buildings) {

        Building mostRight = findMostRight(buildings);
        width = mostRight.x + mostRight.width;

        Building tallest = findTallest(buildings);
        height = tallest.height;

        skyline = new int[width];
        fillSkyLine(buildings);
        detectEdges();

        edges.forEach(System.out::println);

        prettyPrint();
    }

    private void detectEdges() {
        for (int x = 0; x < width; x++) {
            int current = skyline[x];
            int previous = x == 0 ? 0 : skyline[x - 1];
            if (previous < current) {
                edges.add(new Edge(x, skyline[x], true));
            }
            if (previous > current) {
                edges.add(new Edge(x, skyline[x], false));
            }
        }
        edges.add(new Edge(width, 0, false));
    }

    private void fillSkyLine(List<Building> buildings) {
        for (Building building : buildings) {
            fillSkyLine(building);
        }
    }

    private void fillSkyLine(Building building) {
        for (int x = building.x; x < building.x + building.width; x++) {
            if (skyline[x] < building.height) {
                skyline[x] = building.height;
            }
        }
    }


    private Building findMostRight(List<Building> buildings) {
        Optional<Building> mostRight = buildings.stream().reduce((a, b) ->
                a.x > b.x ? a : b);
        //noinspection OptionalGetWithoutIsPresent
        return mostRight.get();
    }

    public void prettyPrint() {
        System.out.println();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int h = height - y;
                System.out.print(skyline[x] >= h ? "@" : " ");
            }
            System.out.println();
        }
        for (int x = 0; x < width; x++) {
            System.out.print(x % 10);
        }
        System.out.println();
    }

    private Building findTallest(List<Building> buildings) {
        Optional<Building> mostRight = buildings.stream().reduce((a, b) ->
                a.height > b.height ? a : b);
        //noinspection OptionalGetWithoutIsPresent
        return mostRight.get();
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
