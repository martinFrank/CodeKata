package com.github.martinfrank.skyline;

import java.util.Objects;

public class Edge {

    public final int x;
    public final int height;

    public Edge(int x, int height){
        this.x = x;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return x == edge.x && height == edge.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, height);
    }
}
