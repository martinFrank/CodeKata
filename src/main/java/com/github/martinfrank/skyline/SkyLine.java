package com.github.martinfrank.skyline;

import java.util.*;

public class SkyLine {

    private final int width;
    private final Set<Edge> edges = new HashSet<>();
    private final List<Building> buildings;

    public SkyLine(List<Building> buildings) {
        this.buildings = buildings;
        Building mostRight = findMostRight(buildings);
        width = mostRight.x + mostRight.width;
        addEdges();
    }

    private void addEdges() {
        buildings.forEach(b -> {
            addEdge(b.x);
            addEdge(b.x + b.width);
        });
        edges.add(new Edge(width, 0));
    }

    private void addEdge(int x) {
        int skyline = getSkyLine(x);
        int previous = x == 0 ? 0 : getSkyLine(x - 1);
        if (previous < skyline || previous > skyline) {
            edges.add(new Edge(x, skyline));
        }
    }

    private int getSkyLine(int x) {
        return buildings.stream()
                .filter(b -> b.x <= x && b.x + b.width > x)
                .mapToInt(b -> b.height)
                .max()
                .orElse(0);
    }

    private Building findMostRight(List<Building> buildings) {
        return Collections.max(buildings, Comparator.comparingInt(b -> b.x));
    }

    public Set<Edge> getEdges() {
        return edges;

    }

}
